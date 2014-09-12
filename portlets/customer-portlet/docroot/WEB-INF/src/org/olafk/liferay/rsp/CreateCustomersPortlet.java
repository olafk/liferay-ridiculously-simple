package org.olafk.liferay.rsp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.xmlportletfactory.olafk.customer.model.Customer;
import org.xmlportletfactory.olafk.customer.model.Invoices;
import org.xmlportletfactory.olafk.customer.service.CustomerLocalServiceUtil;
import org.xmlportletfactory.olafk.customer.service.InvoicesLocalServiceUtil;

/**
 * Portlet implementation class CreateCustomersPortlet
 */
public class CreateCustomersPortlet extends MVCPortlet {

	public void processAction(ActionRequest request, ActionResponse response) {
		String sCount = ParamUtil.getString(request, "count");
		int count = Integer.valueOf(sCount);
		ServiceContext serviceContext = new ServiceContext();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		for (int i = 0; i < count; i++) {
			Customer customer = CustomerLocalServiceUtil.createCustomer(0);
			customer.setName(getRandomName());
			customer.setStreet(getRandomStreet());
			customer.setZip(getRandomZip());
			customer.setCity(getRandomCity());
			customer.setUserId(themeDisplay.getUserId());
			customer.setGroupId(themeDisplay.getScopeGroupId());
			customer.setCompanyId(themeDisplay.getCompanyId());
			try {
				customer = CustomerLocalServiceUtil.addCustomer(customer, serviceContext);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
			int invoiceCount = (int)(Math.random()*2+2);
			while(invoiceCount-- >0) {
				Invoices invoice = InvoicesLocalServiceUtil.createInvoices(0);
				invoice.setCompanyId(themeDisplay.getCompanyId());
				invoice.setGroupId(themeDisplay.getScopeGroupId());
				invoice.setUserId(themeDisplay.getUserId());

				invoice.setAmount((long) (Math.random()*10000));
				invoice.setCustomerId(customer.getCustomerId());
				invoice.setDate(getRandomDate());
				invoice.setPaid(Math.random()>0.8);
				try {
					InvoicesLocalServiceUtil.addInvoices(invoice, serviceContext);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	private Date getRandomDate() {
		GregorianCalendar gc = new GregorianCalendar();
        int year = (int) (Math.random()*5+2009);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = (int) (Math.random()*360+2);
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return gc.getTime();
	}

	private String getRandomCity() {
		return getRandomValue(cities);
	}

	private String getRandomZip() {
		return ""+ (int)(Math.random()*9000 + 1000);
	}

	private String getRandomStreet() {
		return getRandomValue(street1) + " " + getRandomValue(street2);
	}

	private String getRandomName() {
		return getRandomValue(company1) + " " + getRandomValue(company2);
	}

	private String getRandomValue(String[] source) {
		return source[(int)(Math.random()*source.length)];
	}
	
	
	private String[] company1 = new String[] {
			"Liferay",
			"Ray of Light",
			"Nightray",
			"Literay",
			"The Best",
			"Great Company",
			"No. 1",
			"Outgoing Income",
			"Junk and Trash Cutters",
			"Death or Taxes",
			"Great One",
			"Dull",
			"Hillarious",
			"Geek",
			"Nerd",
			"Chaos",
			"Chaotic",
			"Limited",
			"My Own",
			"John Doe",
			"Everybody's Darling",
			"Generic Shopping Malls",
			"Outdoor Clothing",
			"Indoor Clothing",
			"Furniture For Geeks",
			"Radio Liferay"};
	
		private String[] company2 = new String[] {
				"Inc.",
				"Ltd.",
				"AG",
				"GmbH",
				"& Co.",
				"KG",
				"gGmbH",
				"GmbH & Co KG",
				"e.K.",
		};
		
		private String[] street1 = new String[] {
				"1st",
				"2nd",
				"3rd",
				"4th",
				"5th",
				"6th",
				"7th",
				"8th",
				"9th",
				"10th",
				"11th",
				"12th",
				"13th",
				"European",
				"American",
				"Pacific",
				"German",
				"Canadian",
				"French",
				"Danish",
				"Swedish",
				"Central",
				"Decentral",
				"Rural",
				"One Way",
				"Dull",
				"Looping",
				"Confusing",
				"Boring",
				"Interesting",
				"Market",
				"Mediocre",
				"Demonstration",
				"Test",
				"Some"
		};
	
		private String[] street2 = new String[] {
				"Avenue",
				"Street",
				"Way",
				"Path",
				"Intersection",
				"Place",
				"Chaussee",
				"Avenue",
				"Street",
				"Test"
		};

		private String [] cities = new String[] {
				"Hamburg",
				"Los Angeles",
				"Paris",
				"Rome",
				"Amsterdam",
				"Frankfurt",
				"Berlin",
				"Stockholm",
				"New York",
				"Boston",
				"Darmstadt",
				"Madrid",
				"Antwerp",
				"Munich",
				"Dallas",
				"San Francisco",
				"Diamond Bar",
				"Pointe-à-Pitre",
				"Chicago"
		};

}

