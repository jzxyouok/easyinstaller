package com.jianglibo.vaadin.dashboard.view.box;

import org.springframework.context.MessageSource;

import com.jianglibo.vaadin.dashboard.domain.Box;
import com.jianglibo.vaadin.dashboard.domain.Domains;
import com.jianglibo.vaadin.dashboard.repositories.BoxRepository;
import com.jianglibo.vaadin.dashboard.uicomponent.table.TableBase;
import com.jianglibo.vaadin.dashboard.util.ListViewFragmentBuilder;
import com.jianglibo.vaadin.dashboard.view.ListView;
import com.vaadin.data.Property;

@SuppressWarnings("serial")
public class BoxTable extends TableBase<Box> {
	
	public BoxTable(MessageSource messageSource, Domains domains,BoxContainer container, BoxRepository repository, ListView listview) {
		super(Box.class, domains,container, messageSource);
		container.setEnableSort(true);
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

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
