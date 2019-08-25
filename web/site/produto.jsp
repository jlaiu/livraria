<%@page import="dao.EditoraDAO"%>
<%@page import="modelo.Editora"%>
<%@page import="modelo.Autor"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Livro"%>
<%@page import="dao.LivroDAO"%>
<%@include file="cabecalho.jsp" %>

<%
    if(request.getParameter("id") == null){
        response.sendRedirect("index.jsp");
        return;
    }
    
    LivroDAO dao = new LivroDAO();
    Livro livro = new Livro();
    Integer id = Integer.parseInt(request.getParameter("id"));
    livro = dao.buscarPorChavePrimaria(id);
    //List<Livro> lista = dao.listar();
    dao.fecharConexao();
%>

<%
    EditoraDAO e = new EditoraDAO();
%>


<!-- Product -->
<br></br><br></br><br></br>
	<div class="product">
		<div class="container">
			<div class="row"></div>
			<div class="row product_row">
				<!-- Product Image -->
				<div class="col-lg-7">
					<div class="product_image">
						<div class="product_image_large"><img src="../arquivos/<%=livro.getImagem1()%>" alt=""/></div>
						<div class="product_image_thumbnails d-flex flex-row align-items-start justify-content-start">
							<div class="product_image_thumbnail" style="background-image:url(images/product_image_1.jpg)" data-image="images/product_image_1.jpg"></div>
							<div class="product_image_thumbnail" style="background-image:url(images/product_image_2.jpg)" data-image="images/product_image_2.jpg"></div>
							<div class="product_image_thumbnail" style="background-image:url(images/product_image_4.jpg)" data-image="images/product_image_4.jpg"></div>
						</div>
					</div>
				</div>

				<!-- Product Content -->
				<div class="col-lg-5">
					<div class="product_content">
                                            <div class="product_name"><%=livro.getNome()%></div>
                                            <span>
                                                <%
                                                    for (Autor a : livro.getAutorList()) {
                                                %>
                                                    <a class="index?id=<%=a.getId()%>">
                                                        <%=a.getNome()%></a>
                                                <%}
                                                %>
                                                </span>
						<div class="product_price">R$ <%=livro.getPreco()%></div>
						 
                                                <div class="product_name">EDITORA: <%=livro.getEditora().getNome()%></div>
                                                
                                                <div class="product_name">CATEGORIA: <%=livro.getCategoria().getNome()%></div>
                                                
						<!-- In Stock -->
						<div class="in_stock_container">
							<div class="in_stock in_stock_true"></div>
							<span>Em estoque</span>
						</div>
                                                <p></p>
						<div class="product_text"> DESCRIÇÃO:
							<p><%=livro.getSinopse()%></p>
						</div>
                                              
						<!-- Product Quantity -->
						<div class="product_quantity_container">
							<span>Quantidade</span>
							<div class="product_quantity clearfix">
								<input id="quantity_input" type="text" pattern="[0-9]*" value="1">
								<div class="quantity_buttons">
									<div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-caret-up" aria-hidden="true"></i></div>
									<div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-caret-down" aria-hidden="true"></i></div>
								</div>
							</div>
						</div>
                                                <div class="button cart_button"><a href="carrinho.jsp?id=<%=livro.getId()%>">COMPRAR</a></div>
					</div>
				</div>
			</div>
		</div>		
	</div>

<%@include file="rodape.jsp" %>