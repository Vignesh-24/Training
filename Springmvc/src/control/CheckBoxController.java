package control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("checkbox")
public class CheckBoxController {
	
	private ItemList list;
	
	public CheckBoxController() {
		list=new ItemList();
		getModel();
	}

	@ModelAttribute("modelItemList")
	public List<String> getModel() {
		List<String> modelItemList=new ArrayList<>();
		modelItemList.add("rice");
		modelItemList.add("daal");
		modelItemList.add("groundnut");
		return modelItemList;
	}
	public final ItemList getList() {
		return list;
	}

	public final void setList(ItemList list) {
		this.list = list;
	}

	
	@RequestMapping(value="loadcheckform", method=RequestMethod.GET)
	public ModelAndView loadCheckBoxForm(ModelAndView mandv) {
		mandv.addObject("list",list);
		mandv.setViewName("checkboxform");
		return mandv;
	}
	
	@RequestMapping(value="submitcheckform", method=RequestMethod.POST)
	public ModelAndView submitCheckBoxForm(ItemList itemlist,ModelAndView mandv) {
		mandv.addObject("itemlist",itemlist.getItemlist());
		mandv.setViewName("display");
		return mandv;
	}
}

class ItemList{
	private List<String> itemlist;

	public List<String> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<String> itemlist) {
		this.itemlist = itemlist;
	}
	
}