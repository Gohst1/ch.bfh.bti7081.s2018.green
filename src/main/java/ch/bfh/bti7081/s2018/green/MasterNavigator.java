package ch.bfh.bti7081.s2018.green;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.green.models.Patient;
import ch.bfh.bti7081.s2018.green.presenters.JournalPresenter;
import ch.bfh.bti7081.s2018.green.presenters.MedicationPresenter;
import ch.bfh.bti7081.s2018.green.views.JournalView;
import ch.bfh.bti7081.s2018.green.views.MedicationView;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")

// The main-class of the application

public class MasterNavigator extends UI {

	
	public static Navigator navigator;
	

	@Override
	protected void init(VaadinRequest request) {
		
		// makes some general settings and sets the mainframe		
		getPage().setTitle("Patient Management System");		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);		
		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		
		// Initialization of the navigator
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		
		// Assembles all presenters/views and adds them to the navigator
		initializeClasses();
		
		// Navigates to the startpage
		navigator.navigateTo(PageName.JOURNAL.getName());

	}
	
	// Initializes all the classes and adds them to the navigator
	
	private void initializeClasses() {		
		
		Patient matthias = new Patient("Matthias");		
		DataContainer data = new DataContainer();
		data.setCurrentPatient(matthias);


		// Create and add one presenter per View
		
		JournalView jv = new JournalView();
		JournalPresenter jp = new JournalPresenter(jv, data);
		navigator.addView(PageName.JOURNAL.getName(), jv);
				
		MedicationView mv = new MedicationView();
		MedicationPresenter mp  = new MedicationPresenter(mv, data);
		navigator.addView(PageName.MEDICATION.getName(), mv);		
	}
			

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MasterNavigator.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
		
	}
}
