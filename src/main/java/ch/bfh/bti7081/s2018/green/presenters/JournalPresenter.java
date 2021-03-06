package ch.bfh.bti7081.s2018.green.presenters;

import ch.bfh.bti7081.s2018.green.DataContainer;
import ch.bfh.bti7081.s2018.green.views.JournalView;

public class JournalPresenter {

    private JournalView view;
    private DataContainer data;

    public JournalPresenter(JournalView view) {
        this.view = view;
        this.data = DataContainer.getInstance();

        enteredView();

        this.view.getBtnChange().addClickListener(clickEvent -> {
            // TODO: Implement method
            //data.getCurrentPatient().addJournalEntry("17.05 Suizidversuch");
            //this.view.setJournalEntries(data.getCurrentPatient().getJournalEntries());
        });
    }

    private void enteredView() {

        // will be called when corresponding view is about to open
        // use this method to populate the view-elements with data

        // TODO: Implement method
        //view.setJournalEntries(data.getCurrentPatient().getJournalEntries());
    }
}
