<%@page import="java.math.BigDecimal"%>
<%@page import="dao.AutorDAO"%>
<%@page import="modelo.Autor"%>
<%@page import="java.util.List"%>

<%@include file="../cabecalho.jsp" %>
<%
    String msg = "";
    String classe = "";
    Autor obj = new Autor();
    AutorDAO dao = new AutorDAO();
    
    if (request.getParameter("txtNome") != null) {
        obj.setNome(request.getParameter("txtNome"));
        obj.setNacionalidade(request.getParameter("txtNacionalidade"));
        obj.setSexo(request.getParameter("txtSexo").charAt(0));
        obj.setFoto(request.getParameter("txtFoto"));        

        Boolean resultado = dao.incluir(obj);
        if (resultado) {
            msg = "Registro cadastrado com sucesso.";
            classe = "alert-success";
        } 
        else {
            msg = "N�o foi poss�vel cadastrar.";
            classe = "alert-danger";
        }
    } 
    

%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema de Livraria Online
            <small>Admin.</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">�rea Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Listagem de Registros 
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3>Cadastro de Autores</h3>
        </div>
       <div class="panel-body">

            <div class="alert <%=classe%>">
                <%=msg%>
            </div>
            <form action="../UploadWS" method="post" enctype="multipart/form-data">

                <div class="col-lg-6">
                    
                    <div class="form-group">
                        <label>Nome:</label>
                        <input class="form-control" type="text"  name="txtNome"  required />
                    </div>
                    
                    <div class="form-group">
                        <label>Nacionalidade:</label>
                        <input class="form-control" type="text"  name="txtNacionalidade" required />
                    </div>
                    
                    <div class="form-group">
                        <label>Sexo: </label>
                        <select name="txtSexo">
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Foto:</label>
                        <input type="file"  name="txtFoto" accept="image/*'" />
                    </div>

                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>

            </form>

        </div>

    </div>
</div>
<!-- 1/.row -->
<%@include file="../rodape.jsp" %>