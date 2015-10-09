package usf.gwt.ui.demo.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import usf.gwt.ui.bootstrap.client.Anchor;
import usf.gwt.ui.bootstrap.client.Group;
import usf.gwt.ui.bootstrap.client.Panel;
import usf.gwt.ui.bootstrap.client.core.BrowserConsole;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;

public class TestSampes<C extends Serializable> extends Composite {

	interface TestUiBinder extends UiBinder<Widget, TestSampes> {}
	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

	@UiField Anchor anchor;
	@UiField Group group;
		
	public TestSampes() {
//		initWidget(uiBinder.createAndBindUi(this));
		Panel p = new Panel();
		initWidget(p);

		final FiltredDataProvider<Client> provider = new FiltredDataProvider<Client>(Arrays.asList(CLIENTS));
		
		ChangeHandler h = new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				provider.refresh();
			}
		};
		

		TextBox fnText = new TextBox(); fnText.setWidth("100px"); p.add(fnText); fnText.addChangeHandler(h);
		TextBox lnText = new TextBox(); lnText.setWidth("100px"); p.add(lnText); lnText.addChangeHandler(h);
		TextBox adText = new TextBox(); adText.setWidth("100px"); p.add(adText); adText.addChangeHandler(h);
		TextBox agText = new TextBox(); agText.setWidth("50px");  p.add(agText); agText.addChangeHandler(h);

		StringFilter<TestSampes.Client> filtFN = new StringFilter<TestSampes.Client>(fnText) {
			@Override
			boolean match(Client bean, String value) {
				return value.equals(bean.firstName);
			}
		};
		StringFilter<TestSampes.Client> filtLN = new StringFilter<TestSampes.Client>(lnText) {
			@Override
			boolean match(Client bean, String value) {
				return value.equals(bean.lastName);
			}
		};
		StringFilter<TestSampes.Client> filtAd = new StringFilter<TestSampes.Client>(adText) {
			@Override
			boolean match(Client bean, String value) {
				return value.equals(bean.adress);
			}
		};
		StringFilter<TestSampes.Client> filtAg = new StringFilter<TestSampes.Client>(agText) {
			@Override
			boolean match(Client bean, String value) {
				return value.equals(bean.age+"");
			}
		};

		provider.add((Filter<Client, C>) filtAd);
		provider.add((Filter<Client, C>) filtFN);
		provider.add((Filter<Client, C>) filtLN);
		provider.add((Filter<Client, C>) filtAg);
		
		
		CellTable<Client> dg = new CellTable<Client>();
		provider.addDataDisplay(dg);
		
		dg.addColumn(countColumn(), "Count"); dg.addColumn(firstNameColumn(), "Prénom"); 
		dg.addColumn(lastNameColumn(), "Nom"); dg.addColumn(adressNameColumn(), "Adresse");
		dg.addColumn(birthdayNameColumn(), "Age");

		Header<String> header = new Header<String>(new TestSampes.JqueryCell()) {
			@Override
			public String getValue() {
				return "ggg";
			}
			
		};
		
		
		dg.addColumn(filtredColumn(), header);
		
		
		SimplePager pager = new SimplePager();
		pager.setDisplay(dg);
		
		p.add(dg);
		p.add(pager);
	}
	
	private Column<Client, Number> countColumn(){
		return new Column<Client, Number>(new NumberCell()) {
			@Override
			public Integer getValue(Client object) {
				return object.num;
			}
		};
	}
	private TextColumn<Client> filtredColumn(){
		return new TextColumn<Client>() {
			@Override
			public String getValue(Client object) {
				return object.firstName;
			}
		};
	}
	private TextColumn<Client> firstNameColumn(){
		return new TextColumn<Client>() {
			@Override
			public String getValue(Client object) {
				return object.firstName;
			}
		};
	}
	private TextColumn<Client> lastNameColumn(){
		return new TextColumn<Client>() {
			@Override
			public String getValue(Client object) {
				return object.lastName;
			}
		};
	}
	private TextColumn<Client> adressNameColumn(){
		return new TextColumn<Client>() {
			@Override
			public String getValue(Client object) {
				return object.adress;
			}
		};
	}
	private Column<Client, Number> birthdayNameColumn(){
		return new Column<Client, Number>(new NumberCell()) {
			@Override
			public Integer getValue(Client object) {
				return object.age;
			}
		};
	}
	
	public static final Client[] CLIENTS;
	
	static {
		String[] fns = {"Youssef", "Thierno", "Emmanuel", "Stéphane", "Glen", "Amir", "Jihed", "Ziad", "Mamadou", "Nicolas", "Anass", "Fayçal", "Olivier", "Othmane"};
		String[] lns = {"ALAMI", "ALAOUI", "DE PLASSE", "MINARY", "PINON", "FAHMI", "MAIRE", "KEVIN", "HELEL"};
		String[] vil = {"Fès", "Paris", "Toulouse", "Rabat", "Mantes la Jolie", "Clichy", "Metz", "Casablanca", "Agadir", "Tanger", "Meknes", "Marrakech"};
		Integer[] age = {55, 26, 12, 44, 89, 120, 44, 84};
		CLIENTS = new Client[20000];
		for(int i=0; i<CLIENTS.length; i++)
			CLIENTS[i] = new Client(nextValue(fns), nextValue(lns), nextValue(vil), nextValue(age));
	}
	private static <C extends Serializable> C nextValue(C[] list) {
		int next = Math.abs(new Random().nextInt()) % list.length;
		return list[next];
	}
	
	public static class Client implements IsSerializable {
		
		protected static int count = 0;
		
		protected String firstName, lastName, adress;
		protected int age, num;
		
		public Client() {
			num = ++count;
		}
		public Client(String firstName, String lastName, String adress, int age) {
			this();
			this.firstName = firstName;
			this.lastName = lastName;
			this.adress = adress;
			this.age = age;
		}
	}
	
	
	public class FiltredDataProvider<T> extends ListDataProvider<T> {
			
		protected List<Filter<T, C>> filters;
		
		public FiltredDataProvider() {
			super(); 
		}
		public FiltredDataProvider(List<T> listToWrap) {
			super(listToWrap);
		}

		boolean add(Filter<T, C> filter){
			if(filters == null)
				filters = new ArrayList<Filter<T, C>>();
			return filters.add(filter);
		}
		
		@Override
		protected void updateRowData(HasData<T>display, int start, List<T> values) {
			if(filters != null){
				//search active filters
				C value = null;
				List<Filter<T, C>> activeFilters = new ArrayList<>();
				for(Filter<T, C> f : filters) {
					value = (f.getWidget() == null) ? null : f.getWidget().getValue();
					if(value != null && !f.matchAll(value))
						activeFilters.add(f);
				}
				if(!activeFilters.isEmpty()) {					
					//search match values
					List<T> filtredValues = new ArrayList<T>();
					Filter<T, C> f = null;
					boolean som = false;
					for(T b : values) {
						Iterator<Filter<T, C>> it = activeFilters.iterator();
						while(it.hasNext() && (som = (f=it.next()).match(b, f.getWidget().getValue())));
						if(som) filtredValues.add(b);
					}
					values = filtredValues;
				}
			}
			super.updateRowData(display, start, values);
			if(values.size() != display.getRowCount()) 
				display.setRowCount(values.size());
		}
	}
	
	public static abstract class Filter<T, C> {
		
		private HasValue<C> widget;
		
		public Filter(HasValue<C> widget) {
			this.widget = widget;
		}
		public HasValue<C> getWidget() {
			return widget;
		}
		
		abstract boolean match(T bean, C value);
		abstract boolean matchAll(C value);
	}
	public static abstract class StringFilter<T> extends Filter<T, String> {
		
		public StringFilter(HasValue<String> widget) {
			super(widget);
		}
		@Override
		boolean matchAll(String value) {
			return value.isEmpty() || "*".equals(value);
		}
		@Override
		abstract boolean match(T bean, String value);
	}
	
	public static class JqueryCell extends AbstractCell<String> {
		
		public JqueryCell() {
			super("");
		}

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context, String value, SafeHtmlBuilder sb) {
			sb.append(SafeHtmlUtils.fromTrustedString("<input type='text'placeholder='filter' value='" + value + "'></input>"));
		}
		
		@Override
		public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
			// TODO Auto-generated method stub

			BrowserConsole.log(parent);
			BrowserConsole.log(context);
			BrowserConsole.log(valueUpdater);
			
			
			super.onBrowserEvent(context, parent, value, event, valueUpdater);
			
		}

	}
	
}
