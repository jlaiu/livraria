<%@page import="modelo.Editora"%>
<%@page import="dao.EditoraDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.LivroDAO"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Autor"%>
<%@page import="java.util.Date"%>
<%@page import="modelo.Livro"%>
<%@page import="modelo.Autor"%>
<%@page import="modelo.Categoria"%>
<%@page import="dao.AutorDAO"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.List"%>

<%@include file="../cabecalho.jsp" %>
<%
    String selecionado;
    String msg = "";
    String classe = "";
    AutorDAO adao = new AutorDAO();
    EditoraDAO edao = new EditoraDAO();
    CategoriaDAO cdao = new CategoriaDAO();
    Livro obj = new Livro();
    if(request.getMethod().equals("POST")){
        //pego uma lista de autores(com mesmo name)
        //sempre que tiver upload de arquivos e n pra n, pega desse jeito
        String[] autoresid = request.getParameter("autoreschk").split(";");
        //popular o livro
        obj.setNome(request.getParameter("txtNome"));
        obj.setPreco(Float.parseFloat(request.getParameter("txtPreco")));
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date Datapublicacao = sf.parse(request.getParameter("txtDatapublicacao"));
        obj.setDatapublicacao(Datapublicacao);
        obj.setSinopse(request.getParameter("txtSinopse"));
        if(request.getParameter("txtImagem1") != null){
            obj.setImagem1(request.getParameter("txtImagem1"));
        }
        if(request.getParameter("txtImagem2") != null){
            obj.setImagem2(request.getParameter("txtImagem2"));
        }
        if(request.getParameter("txtImagem3") != null){
            obj.setImagem3(request.getParameter("txtImagem3"));
        }
        
        
        //Autores
        List<Autor> listaautores = new ArrayList<>();
        for (String id : autoresid) {
            Integer idinteger = Integer.parseInt(id);
            listaautores.add(adao.buscarPorChavePrimaria(idinteger));
         }
        obj.setAutorList(listaautores);
        
        Categoria c = new Categoria();
//        c.setId(Integer.parseInt(request.getParameter("categoriaCombo")));
//        obj.setCategoria(c);

        c = cdao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("categoriaCombo")));
        obj.setCategoria(c);
        
        Editora e = new Editora();
        e = edao.buscarPorChavePrimaria(request.getParameter("editoraCombo"));
        obj.setEditora(e);
        
        LivroDAO dao = new LivroDAO();
//       dao.incluir(obj);
       
        Boolean resultado = dao.incluir(obj);
        if (resultado) {
            msg = "Registro cadastrado com sucesso";
            classe = "alert-success";
        }
        else {
            msg = "Não foi possível cadastrar";
            classe = "alert-danger";
        }
    }
    
    //pego meus autores
    List<Autor> autores = adao.listar();
    List<Editora> editoras = edao.listar();
    List<Categoria> categorias = cdao.listar();

%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema de Livraria Online
            <small>Admin.</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Área Administrativa</a>
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
            <h3>Cadastro de Livros</h3>
        </div>
        <div class="panel-body">

            <div class="alert <%=classe%>">
                <%=msg%>
            </div>
            <form action="../UploadWS" method="post"
                  enctype="multipart/form-data">

                <div class="col-lg-6">
                    
                    <div class="form-group">
                        <label>Nome:</label>
                        <input class="form-control" type="text"  name="txtNome"  required />
                    </div>
                    
                    <div class="form-group">
                        <label>Preço:</label>
                        <input class="form-control" type="text"  name="txtPreco"  required />
                    </div>

                    <div class="form-group">
                        <label>Data de Publicação:</label>
                        <input class="form-control" type="text"  name="txtDatapublicacao" />
                    </div>
                    
                    <div class="form-group">
                        <label>Sinopse: </label> <br>
                        <textarea name="txtSinopse" required ></textarea>
                        
                    </div>
                    
                    <div class="form-group">
                        <label>Editora:</label>
                        <select name="editoraCombo">
                        <%for (Editora e : editoras) {%>
                        <!--<input type="checkbox"  name="editoras"  value="<%=e.getCnpj()%>"><%=e.getNome()%>/>-->  
			<option value=<%=e.getCnpj()%>> <%=e.getNome()%> </option>
                        <%}%>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Categoria:</label>
                        <select name="categoriaCombo">
                        <%for (Categoria c : categorias) {%>
                        <!--<input type="checkbox"  name="categorias"  value="<%=c.getId()%>"><%=c.getNome()%> />-->
                        <option value=<%=c.getId()%>> <%=c.getNome()%> </option
                        <%}%>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Imagem 1:</label>
                        <input type="file"  name="txtImagem1" />
                    </div>
                    
                    <div class="form-group">
                        <label>Imagem 2:</label>
                        <input type="file"  name="txtImagem2" />
                    </div>
                    
                    <div class="form-group">
                        <label>Imagem 3:</label>
                        <input type="file"  name="txtImagem3" />
                    </div>
                    
<!--                    <div class="form-group">
                        <label>Autores</label>
                        <select name="autores" multiple>
                            <%for(Autor a:autores){%>
                            <option value="<%=a.getId()%>"><%=a.getNome()%>
                            </option>
                            <%}%>
                        </select>
                     </div>-->
                        
                        <div class="form-group">
                        <label>Autores: </label>
                       
                            <%for(Autor a:autores){%>
                            
                            <input type="checkbox" name="autoreschk" value="<%=a.getId()%>"><%=a.getNome()%>
                           
                            <%}%>
                        
                     </div>

                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>

            </form>

        </div>


    </div>
</div>
<!-- 1/.row -->
<%@include file="../rodape.jsp" %>