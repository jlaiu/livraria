<%@page import="modelo.Autor"%>
<%@page import="modelo.Livro"%>
<%@page import="java.util.List"%>
<%@page import="dao.LivroDAO"%>
<%@include file="cabecalho.jsp" %>

<%
    LivroDAO dao = new LivroDAO();
    List<Livro> lista = dao.listar();
    dao.fecharConexao();
%>

<!-- New Arrivals -->

	<div class="arrivals">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
                                            <br></br><br></br>
                                            <div class="section_title">LIVROS</div>
					</div>
				</div>
			</div>
			<div class="row products_container">
                            <%
                                for(Livro livro : lista){
                            %>
				<!-- Product -->
				<div class="col-lg-4 product_col">
					<div class="product">
                                                    
                                                
						<div class="product_image">
							<img src="../arquivos/<%=livro.getImagem1()%>" alt=""/>
						</div>
						<div class="rating rating_4">
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
						</div>
						<div class="product_content clearfix">
							<div class="product_info">
                                                        <div class="product_name"><%=livro.getNome()%><a href="product.html"></a></div>
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
							</div>
							<div class="product_options">
                                                            <div class="product_buy product_option"><a href="carrinho.jsp?id=<%=livro.getId()%>"> <img src="images/shopping-bag-white.svg" title="Ir para o carrinho"></a></div>
                                                            <div class="product_fav product_option"><a href="produto.jsp?id=<%=livro.getId()%>" title="Ver detalhes">+</a></div>
                                                                <!--<div><a href="produto.jsp?id=<%=livro.getId()%>">Ver detalhes</a></div>-->
							</div>
						</div>
					</div>
				</div>
                                <%}%>
			</div>
		</div>
	</div>
                        
	<!-- Newsletter -->
<%@include file="rodape.jsp" %>