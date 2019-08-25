<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Compralivro"%>
<%@page import="modelo.Livro"%>
<%@page import="java.util.List"%>
<%@page import="dao.LivroDAO"%>
<%
    if(request.getParameter("id") == null){
        response.sendRedirect("index.jsp");
        return;
    }
    
Integer id = Integer.parseInt(request.getParameter("id"));
LivroDAO dao = new LivroDAO();
Livro l = dao.buscarPorChavePrimaria(id);
List<Compralivro> carrinho;
Compralivro cl = new Compralivro();
cl.setLivro(l);
cl.setValoruni(l.getPreco());

if(session.getAttribute("carrinho") != null){
    carrinho = (List<Compralivro>)session.getAttribute("carrinho");
    carrinho.add(cl);
}

else{
    carrinho = new ArrayList<Compralivro>();
    carrinho.add(cl);
}

session.setAttribute("carrinho", carrinho);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Livraria Veiga</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
</head>
<body>

<div class="super_container">
	
	<!-- Header -->

	<header class="header">
		<div class="header_inner d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a href="#"><h2>Livraria Veiga</h2></a></div>
			<nav class="main_nav">
				<ul>
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="contato.jsp">Contato</a></li>
				</ul>
			</nav>
			<div class="header_content ml-auto">
				<div class="search header_search">
					<form action="#">
						<input type="search" class="search_input" required="required">
						<button type="submit" id="search_button" class="search_button"><img src="images/magnifying-glass.svg" alt=""></button>
					</form>
				</div>
				<div class="shopping">
					<!-- Cart -->
					<a href="#">
						<div class="cart">
							<img src="images/shopping-bag.svg" alt="">
							<div class="cart_num_container">
								<div class="cart_num_inner">
									<div class="cart_num">1</div>
								</div>
							</div>
						</div>
					</a>
					<!-- Star -->
					<a href="#">
						<div class="star">
							<img src="images/star.svg" alt="">
							<div class="star_num_container">
								<div class="star_num_inner">
									<div class="star_num">0</div>
								</div>
							</div>
						</div>
					</a>
					<!-- Avatar -->
					<a href="#">
						<div class="avatar">
							<img src="images/avatar.svg" alt="">
						</div>
					</a>
				</div>
			</div>

			<div class="burger_container d-flex flex-column align-items-center justify-content-around menu_mm"><div></div><div></div><div></div></div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="logo menu_mm"><a href="#"><h2>Livraria Veiga</h2></a></div>
		<div class="search">
			<form action="#">
				<input type="search" class="search_input menu_mm" required="required">
				<button type="submit" id="search_button_menu" class="search_button menu_mm"><img class="menu_mm" src="images/magnifying-glass.svg" alt=""></button>
			</form>
		</div>
		<nav class="menu_nav">
			<ul class="menu_mm">
                            <li><a href="#">Home</a></li>
                            <li><a href="categories.html">Livros</a></li>
                            <li><a href="categories.html">Promoções</a></li>
                            <li><a href="contact.html">Contato</a></li>
			</ul>
		</nav>
	</div>

	<!-- Cart -->

	<div class="cart_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="cart_title">Seu carrinho de compras</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="cart_bar d-flex flex-row align-items-center justify-content-start">
						<div class="cart_bar_title_name">Produto</div>
						<div class="cart_bar_title_content ml-auto">
							<div class="cart_bar_title_content_inner d-flex flex-row align-items-center justify-content-end">
								<div class="cart_bar_title_price">Preço</div>
								<div class="cart_bar_title_quantity">Quantidade</div>
								<div class="cart_bar_title_total">Total</div>
								<div class="cart_bar_title_button"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
                                    <%
                                        for (Compralivro obj : carrinho) {
                                            
                   
                                    %>
					<div class="cart_products">
						<ul>
							<li class=" cart_product d-flex flex-md-row flex-column align-items-md-center align-items-start justify-content-start">
								<!-- Product Image -->
								<div class="cart_product_image"><img src="../arquivos/<%=obj.getLivro().getImagem1()%>" width="95px" height="95px"/></div>
								<!-- Product Name -->
								<div class="cart_product_name"><a href="product.html"><%=obj.getLivro().getNome()%></a></div>
								<div class="cart_product_info ml-auto">
									<div class="cart_product_info_inner d-flex flex-row align-items-center justify-content-md-end justify-content-start">
										<!-- Product Price -->
                                                                                <div class="cart_product_price"><%=obj.getLivro().getPreco()%></div>
										<!-- Product Quantity -->
										<div class="product_quantity_container">
											<div class="product_quantity clearfix">
												<input id="quantity_input" type="text" pattern="[0-9]*" value="1">
												<div class="quantity_buttons">
													<div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-caret-up" aria-hidden="true"></i></div>
													<div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-caret-down" aria-hidden="true"></i></div>
												</div>
											</div>
										</div>
										<!-- Products Total Price -->
										<div class="cart_product_total"><%=obj.getLivro().getPreco()%></div>
										<!-- Product Cart Trash Button -->
										<div class="cart_product_button">
                                                                                    <button class="cart_product_remove"><img src="images/trash.png" alt="" onclick="%=obj.remove(obj.getLivro().getID())%"></button>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
                                        <%}%>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="cart_control_bar d-flex flex-md-row flex-column align-items-start justify-content-start">
						<button class="button_clear cart_button">Limpar carrinho</button>
						<button class="button_update cart_button">Atualizar carrinho</button>
						<button class="button_update cart_button_2 ml-md-auto">Continuar comprando</button>
					</div>
				</div>
			</div>
				<!-- Cart Total -->
				<div class="col-lg-5 offset-lg-1">
					<div class="cart_total">
                                            <br></br>
						<div class="cart_title">Total</div>
						<ul>
							<li class="d-flex flex-row align-items-center justify-content-start">
								<div class="cart_total_title">Total</div>
								
							</li>
						</ul>
						<button class="cart_total_button"><a href="finalizar.jsp">Concluir compra</a></button>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- Newsletter -->
<%@include file="rodape.jsp"%>