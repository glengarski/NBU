package com.example.infm205;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
@Theme("infm205")
public class Infm205UI extends UI {

	private List<String> items;
	private List<String> items2;

	private VerticalSplitPanel mainLayout;
	private HorizontalLayout menuBar;
	private HorizontalLayout contentLayout;
	private int menuBarSize = 125;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Infm205UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		mainLayout = new VerticalSplitPanel();
		menuBar = new HorizontalLayout();
		contentLayout = new HorizontalLayout();

		mainLayout.setSplitPosition(menuBarSize, Unit.PIXELS);
		mainLayout.setMinSplitPosition(menuBarSize, Unit.PIXELS);
		mainLayout.setMaxSplitPosition(menuBarSize, Unit.PIXELS);

		items = new ArrayList<String>();
		items2 = new ArrayList<String>();
		items2.add("asdf");
		items2.add("asdf1");

		items.add("asdf");
		items.add("asdf1");
		items.add("bsdf");
		items.add("basdf2");

		Table table = new Table();

		contentLayout.addComponent(table);

		menuBar.setMargin(true);
		menuBar.setSpacing(true);
		setContent(mainLayout);

		ComboBox searchBox = new ComboBox();
		searchBox.addItems(items);
		searchBox.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				System.out.println(event.getProperty().getValue());
			}
		});

		ComboBox cond = new ComboBox();
		cond.addItems(items2);
		cond.setNullSelectionAllowed(false);
		cond.setNewItemsAllowed(false);
		cond.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				System.out.println(event.getProperty().getValue());
			}
		});

		menuBar.addComponent(new Label("Search: "));
		menuBar.addComponent(searchBox);

		menuBar.addComponent(new Label("  field 2 "));
		menuBar.addComponent(cond);

		mainLayout.setFirstComponent(menuBar);

		mainLayout.setSecondComponent(contentLayout);
	}

}