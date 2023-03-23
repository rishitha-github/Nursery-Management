package com.nursery;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nmod.Cmod;
import com.nmod.Nmod;

import Ndao.Ndao;


@WebServlet("/")
public class Nserv extends HttpServlet {
	RequestDispatcher rd;
	private static final long serialVersionUID = 1L;
  
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path)
		{
		case"/dis":
			getDis(request,response);
			break;
		case "/add":
			addStock(request,response);break;
		case "/func":
			function(request,response);break;
		case "/verify":
			getVerify(request,response);break;
		case "/sell":
			sell(request,response);break;
		case "/cdis" :
			cdisplay(request,response);break;
		case "/back" :
			back(request,response);break;
		case "/back1" :
			back1(request,response);break;
		case "/back2" :
			back2(request,response);break;
			
		}
	}

	// redirecting to AddStock page
	private void back2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		rd=request.getRequestDispatcher("do.jsp");
		try {
	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//redirecting to Buttons page
	private void back1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		rd=request.getRequestDispatcher("action.jsp");
		try {
	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

//redirecting to Login page
	private void back(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		rd=request.getRequestDispatcher("login.jsp");
		try {
	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

//redirecting to customers details page
	private void cdisplay(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Cmod> all=Ndao.cdisplay();
		rd=request.getRequestDispatcher("customer.jsp");
		try {
			request.setAttribute("cdis", all);
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void sell(HttpServletRequest request, HttpServletResponse response) {
		int stockid = Integer.parseInt(request.getParameter("snumber"));
		String cname = request.getParameter("cname");
		Long cnum = Long.parseLong(request.getParameter("cnum"));
		int camount = Integer.parseInt(request.getParameter("anum"));
		Ndao.delete(stockid);
		int count =Ndao.cinsert(cname, cnum,camount);
		if(count>0) {
		try {
			response.sendRedirect("dis");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


	private void getDis(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Nmod> al=Ndao.display();
		rd= request.getRequestDispatcher("display.jsp");
		try {
			request.setAttribute("dis", al);
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void addStock(HttpServletRequest request, HttpServletResponse response) {
	int number=Integer.parseInt(request.getParameter("number"));
	int price=Integer.parseInt(request.getParameter("price"));
	int count=Ndao.insert(number, price);
		if(count>0)
		{
			rd=request.getRequestDispatcher("success.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			rd=request.getRequestDispatcher("do.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}


	private void function(HttpServletRequest request, HttpServletResponse response) {
rd=request.getRequestDispatcher("do.jsp");
try {
	rd.forward(request, response);
} catch (ServletException | IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}


	private void getVerify(HttpServletRequest request, HttpServletResponse response) {
		String uname1=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String res=Ndao.veri(uname1, pass);
		if(res.equals("success"))
		{
			rd=request.getRequestDispatcher("action.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			rd=request.getRequestDispatcher("login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
