package org.olafk.liferay.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class SimplifiedArticle
 */
public class SimplifiedArticle extends MVCPortlet {
 
	public void submitArticle(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String title = ParamUtil.getString(actionRequest, "title");
		String htmlContentEn = ParamUtil.getString(actionRequest, "htmlEditorEn");
		String htmlContentDe = ParamUtil.getString(actionRequest, "htmlEditorDe");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			addJournalArticle(
					themeDisplay.getUserId(), 
					themeDisplay.getScopeGroupId(), 
					title, 
					htmlContentEn,
					htmlContentDe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(htmlContentEn);
	}
		
	public static JournalArticle addJournalArticle(
		    long userId, long groupId, String title, String contentEn, String contentDe)
		    throws Exception {
		
		ServiceContext serviceContext = new ServiceContext();

	    serviceContext.setAddGroupPermissions(true);
	    serviceContext.setAddGuestPermissions(true);
	    serviceContext.setScopeGroupId(groupId);
	    serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
	    Map<Locale, String> titleMap = new HashMap<Locale, String>();
	    Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

	    titleMap.put(Locale.US, title);
	    titleMap.put(Locale.GERMANY, title);
	    descriptionMap.put(Locale.US, title);
	    descriptionMap.put(Locale.GERMANY, title);

	    try {
	        JournalArticleLocalServiceUtil.deleteArticle(groupId, title, serviceContext);
	    } catch (Exception ex) {
	        System.out.println("Ignoring " + ex.getMessage());
	    }

	    String xmlContent = "<?xml version='1.0' encoding='UTF-8'?>" +
	    		"<root default-locale=\"en_US\" available-locales=\"en_US,de_DE\">" +
	    			"<static-content language-id=\"en_US\">" +
	    				"<![CDATA[" + contentEn + "]]>" +
	    			"</static-content>" +
	    			"<static-content language-id=\"de_DE\">" +
	    				"<![CDATA[" + contentDe + "]]>" +
	    			"</static-content>" +
	    		"</root>";
	       
	    JournalArticle article = JournalArticleLocalServiceUtil.addArticle(
	    		userId, groupId, 0, 
	    		0, 0, title, true, 
	    		JournalArticleConstants.VERSION_DEFAULT, titleMap, 
	    		descriptionMap, xmlContent, 
	    		"general", null, null, null, 
	    		1, 1, 2014, 0, 0,
	    		0, 0, 0, 0, 0, true, 
	    	    0, 0, 0, 0, 0, true, 
	    	    true, false, null, null, 
	    		null, null, serviceContext);
	    
	    return article;
	}
}
