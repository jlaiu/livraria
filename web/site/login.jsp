<%@page import="modelo.Cliente"%>
<%@page import="dao.ClienteDAO"%>
<%
    //Se os dois campos forem informados, é login
    if(request.getParameter("txtEmail")!=null && 
            request.getParameter("txtSenha")!= null){
        ClienteDAO dao = new ClienteDAO();
        Cliente cli = dao.logar(request.getParameter("txtEmail"), 
                request.getParameter("txtSenha"));
        
        if(cli != null){
            session.setAttribute("cliente", cli);
            response.sendRedirect("finalizar.jsp");
            return;
        }
        else{
            %>
            <script>alert('Login e/ou senha inválidos.');
            </script>
            <%}
        }
        //Se preencheu o cadastro
        if(request.getParameter("txtNEmail")!=null && 
            request.getParameter("txtNSenha")!= null && 
            request.getParameter("txtNEnd")!= null &&
            request.getParameter("txtNNome")!= null){
        ClienteDAO dao = new ClienteDAO();
        Cliente cli = new Cliente();
        cli.setEmail(request.getParameter("txtNEmail"));
        cli.setEndereco(request.getParameter("txtNEnd"));
        cli.setSenha(request.getParameter("txtNSenha"));
        cli.setNome(request.getParameter("txtNNome"));
        dao.incluir(cli);

        session.setAttribute("cliente", cli);
        response.sendRedirect("finalizar.jsp");
        return;
    }
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
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
<link rel="stylesheet" type="text/css" href="styles/checkout_responsive.css">
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
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="contato.jsp">Contato</a></li>
			</ul>
		</nav>
	</div>

	<!-- Checkout -->

	<div class="checkout">
		<div class="container">
			<div class="row">

				<!-- Billing Details -->
				<div class="col-lg-6">
					<div class="billing">
                                            <br></br><br></br>
                                            <form method="post" action="#" >
						<div class="checkout_title">Login</div>
						<div class="checkout_form_container">
							<form action="#" id="checkout_form">
                                                            <label for="fname">E-mail</label>
								<input type="email" id="fname" name="txtEmail" class="checkout_input" placeholder="Digite seu e-mail" required="required">
                                                                <label for="lname">Senha</label>        
                                                                <input type="password" id="lname" name="txtSenha" class="checkout_input" placeholder="Digite sua senha" required="required">
								<button class="cart_total_button"><a href="finalizar.jsp">ENTRAR</a></button>
                                                        </form>
						</div>
                                                <br></br>
                                                <div class="checkout_title">CADASTRO</div>
						<div class="checkout_form_container">
							<form action="#" id="checkout_form">
                                                            <label for="fname">E-mail</label>
                                                            <input type="email" id="fname" name="txtNEmail" class="checkout_input" placeholder="Digite seu e-mail" required="required">
                                                            <label for="lname">Senha</label>        
                                                            <input type="password" id="lname" name="txtNSenha" class="checkout_input" placeholder="Digite sua senha" required="required">
                                                            <label for="lnome">Nome</label>        
                                                            <input type="text" id="lnome" name="txtNNome" class="checkout_input" placeholder="Digite seu nome" required="required">
                                                            <label for="fend">Endereço</label>    
                                                            <input type="text" id="fend" name="txtNEnd" class="checkout_input" placeholder="Digite seu endereço" required="required">    
                                                            <div class="billing_options">
								<button class="cart_total_button"><a href="finalizar.jsp">CADASTRAR</a></button>
                                                            </div>
                                                        </form>
						</div>
                                                </form>
						</div>
					</div>
                                    
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- Newsletter -->
<%@include file="rodape.jsp"%>