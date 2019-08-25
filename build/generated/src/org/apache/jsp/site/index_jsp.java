package org.apache.jsp.site;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Autor;
import modelo.Livro;
import java.util.List;
import dao.LivroDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/site/cabecalho.jsp");
    _jspx_dependants.add("/site/rodape.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("<head>\n");
      out.write("<title>Livraria Veiga</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"description\" content=\"Wish shop project\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\n");
      out.write("<link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/animate.css\">\n");
      out.write("<link href=\"plugins/colorbox/colorbox.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main_styles.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/responsive.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"super_container\">\n");
      out.write("\t\n");
      out.write("\t<!-- Header -->\n");
      out.write("\n");
      out.write("\t<header class=\"header\">\n");
      out.write("\t\t<div class=\"header_inner d-flex flex-row align-items-center justify-content-start\">\n");
      out.write("\t\t\t<div class=\"logo\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t\t<nav class=\"main_nav\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"contato.jsp\">Contato</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t<div class=\"header_content ml-auto\">\n");
      out.write("\t\t\t\t<div class=\"search header_search\">\n");
      out.write("\t\t\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t\t\t<input type=\"search\" class=\"search_input\" required=\"required\">\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" id=\"search_button\" class=\"search_button\"><img src=\"images/magnifying-glass.svg\" alt=\"\"></button>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"shopping\">\n");
      out.write("\t\t\t\t\t<!-- Cart -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"cart\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/shopping-bag.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"cart_num_container\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"cart_num_inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"cart_num\">1</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<!-- Star -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"star\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/star.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"star_num_container\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"star_num_inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"star_num\">0</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<!-- Avatar -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"avatar\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/avatar.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"burger_container d-flex flex-column align-items-center justify-content-around menu_mm\"><div></div><div></div><div></div></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<!-- Menu -->\n");
      out.write("\n");
      out.write("\t<div class=\"menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400\">\n");
      out.write("\t\t<div class=\"menu_close_container\"><div class=\"menu_close\"><div></div><div></div></div></div>\n");
      out.write("\t\t<div class=\"logo menu_mm\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t<div class=\"search\">\n");
      out.write("\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t<input type=\"search\" class=\"search_input menu_mm\" required=\"required\">\n");
      out.write("\t\t\t\t<button type=\"submit\" id=\"search_button_menu\" class=\"search_button menu_mm\"><img class=\"menu_mm\" src=\"images/magnifying-glass.svg\" alt=\"\"></button>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<nav class=\"menu_nav\">\n");
      out.write("\t\t\t<ul class=\"menu_mm\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">Home</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"categories.html\">Livros</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"categories.html\">Promoções</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"contact.html\">Contato</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</div>\n");
      out.write('\n');
      out.write('\n');

    LivroDAO dao = new LivroDAO();
    List<Livro> lista = dao.listar();
    dao.fecharConexao();

      out.write("\n");
      out.write("\n");
      out.write("<!-- New Arrivals -->\n");
      out.write("\n");
      out.write("\t<div class=\"arrivals\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col\">\n");
      out.write("\t\t\t\t\t<div class=\"section_title_container text-center\">\n");
      out.write("                                            <br></br><br></br>\n");
      out.write("                                            <div class=\"section_title\">LIVROS</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row products_container\">\n");
      out.write("                            ");

                                for(Livro livro : lista){
                            
      out.write("\n");
      out.write("\t\t\t\t<!-- Product -->\n");
      out.write("\t\t\t\t<div class=\"col-lg-4 product_col\">\n");
      out.write("\t\t\t\t\t<div class=\"product\">\n");
      out.write("                                                    \n");
      out.write("                                                \n");
      out.write("\t\t\t\t\t\t<div class=\"product_image\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"../arquivos/");
      out.print(livro.getImagem1());
      out.write("\" alt=\"\"/>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"rating rating_4\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"product_content clearfix\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"product_info\">\n");
      out.write("                                                        <div class=\"product_name\">");
      out.print(livro.getNome());
      out.write("<a href=\"product.html\"></a></div>\n");
      out.write("                                                        <span>\n");
      out.write("                                                            ");

                                                                for (Autor a : livro.getAutorList()) {
                                                            
      out.write("\n");
      out.write("                                                            <a class=\"index?id=");
      out.print(a.getId());
      out.write("\">\n");
      out.write("                                                                ");
      out.print(a.getNome());
      out.write("</a>\n");
      out.write("                                                            ");
}
                                                            
      out.write("\n");
      out.write("                                                        </span>\n");
      out.write("                                                        <div class=\"product_price\">R$ ");
      out.print(livro.getPreco());
      out.write("</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"product_options\">\n");
      out.write("                                                            <div class=\"product_buy product_option\"><a href=\"carrinho.jsp?id=");
      out.print(livro.getId());
      out.write("\"> <img src=\"images/shopping-bag-white.svg\" title=\"Ir para o carrinho\"></a></div>\n");
      out.write("                                                            <div class=\"product_fav product_option\"><a href=\"produto.jsp?id=");
      out.print(livro.getId());
      out.write("\" title=\"Ver detalhes\">+</a></div>\n");
      out.write("                                                                <!--<div><a href=\"produto.jsp?id=");
      out.print(livro.getId());
      out.write("\">Ver detalhes</a></div>-->\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("                        \n");
      out.write("\t<!-- Newsletter -->\n");
      out.write("        <br><br/><br><br/><br><br/>\n");
      out.write("\t<div class=\"newsletter\">\n");
      out.write("\t\t<div class=\"newsletter_content\">\n");
      out.write("\t\t\t<div class=\"newsletter_image\" style=\"background-image:url(images/newsletter.jpg)\"></div>\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t<div class=\"col\">\n");
      out.write("\t\t\t\t\t\t<div class=\"section_title_container text-center\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"section_title\">Assine para receber novidades</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"row newsletter_container\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-10 offset-lg-1\">\n");
      out.write("\t\t\t\t\t\t<div class=\"newsletter_form_container\">\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" class=\"newsletter_input\" required=\"required\" placeholder=\"E-mail\">\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"newsletter_button\">Assinar</button>\n");
      out.write("\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"newsletter_text\">Assine e receba por e-mail todas as promoções e novidades da semana.</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Footer -->\n");
      out.write("        \n");
      out.write("\t<footer class=\"footer\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col text-center\">\n");
      out.write("                                    <div class=\"footer_logo\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t\t\t\t<nav class=\"footer_nav\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("                                                    <li><a href=\"#\">Home</a></li>\n");
      out.write("                                                    <li><a href=\"categories.html\">Livros</a></li>\n");
      out.write("                                                    <li><a href=\"categories.html\">Promoções</a></li>\n");
      out.write("                                                    <li><a href=\"contact.html\">Contato</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <div class=\"footer_social\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("                                                    <li><a href=\"https://www.w3schools.com\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                                    <br><br/>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("<script src=\"styles/bootstrap4/popper.js\"></script>\n");
      out.write("<script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n");
      out.write("<script src=\"plugins/easing/easing.js\"></script>\n");
      out.write("<script src=\"plugins/parallax-js-master/parallax.min.js\"></script>\n");
      out.write("<script src=\"plugins/colorbox/jquery.colorbox-min.js\"></script>\n");
      out.write("<script src=\"js/custom.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
