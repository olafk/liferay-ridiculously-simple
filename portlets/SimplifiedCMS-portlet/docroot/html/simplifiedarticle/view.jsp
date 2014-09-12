<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="submitArticle" var="submitArticle"></portlet:actionURL>

<aui:form action="<%=submitArticle %>">
  <aui:fieldset>
	<aui:input name="title" type="text" inlineLabel="true"/>
	<aui:field-wrapper label="english-article">
		<liferay-ui:input-editor name="enEditor" initMethod="initEn" />
	</aui:field-wrapper>
	<aui:field-wrapper label="german-article">
		<liferay-ui:input-editor name="deEditor" initMethod="initDe" />
	</aui:field-wrapper>
	<input name="<portlet:namespace />htmlEditorEn" type="hidden" value="" />
	<input name="<portlet:namespace />htmlEditorDe" type="hidden" value="" />
	<input type="submit" onclick="<portlet:namespace/>extractCodeFromEditor(); return true;"/>
  </aui:fieldset>
</aui:form>

<script type="text/javascript">
	function <portlet:namespace />initEn() {
		return 'enter your new article here, in english';
	}
	function <portlet:namespace />initDe() {
		return 'deutscher Inhalt für den neuen Artikel';
	}

    function <portlet:namespace />extractCodeFromEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />htmlEditorEn.value = window.<portlet:namespace />enEditor.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />htmlEditorDe.value = window.<portlet:namespace />deEditor.getHTML();
	}
</script>

Quick Links to get more or less meaningful text:
<ul>
<li><a href="http://baconipsum.com">Bacon Ipsum</a></li>
<li><a href="http://blindtextgenerator.de/">Blindtextgenerator (german)</a></li>
</ul>