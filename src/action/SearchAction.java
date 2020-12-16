package ao.app.productmaster.action;

import ao.app.productmaster.bean.Product;
import ao.app.productmaster.dao.ProductDAO;
import javax.servlet.http.*;
import java.util.List;

public class SearchAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String keyword=request.getParameter("keyword");
		if (keyword==null) keyword="";

		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);

		session.setAttribute("list", list);

		return "product.jsp";
	}
}