package com.jianglibo.vaadin.dashboard.view.box;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;

import com.jianglibo.vaadin.dashboard.domain.Box;
import com.jianglibo.vaadin.dashboard.domain.Domains;
import com.jianglibo.vaadin.dashboard.repositories.BoxRepository;
import com.jianglibo.vaadin.dashboard.uicomponent.table.TableBase;
import com.jianglibo.vaadin.dashboard.view.ListView;
import com.vaadin.data.Property;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
@SpringComponent
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class BoxTable extends TableBase<Box> {
	
	private BoxContainer container;
	
	@Autowired
	private BoxRepository repository;

	@Autowired
	public BoxTable(Domains domains, MessageSource messageSource) {
		super(Box.class, domains, messageSource);
	}
	
	public Table afterInjection(ListView listview) {
		container = new BoxContainer(repository, domains, listview, this);
		//Because we use sql sort, not the component sort. 
		container.setEnableSort(true);
		return this;
	}
	

	@Override
	public void setFooter() {
		setColumnFooter("createdAt", "");
		setColumnFooter("ip", "Total");
	}
	
	@Override
	protected String formatPropertyValue(final Object rowId, final Object colId, final Property<?> property) {
		String result = super.formatPropertyValue(rowId, colId, property);
		if (colId.equals("createdAt")) {
			result = formatDate(DATEFORMAT, property);
		}
		return result;
	}
}
