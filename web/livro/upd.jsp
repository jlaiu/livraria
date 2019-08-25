<%@page import="util.StormData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Livro"%>
<%@page import="dao.LivroDAO"%>
<%@page import="dao.EditoraDAO"%>
<%@page import="dao.AutorDAO"%>
<%@page import="modelo.Editora"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Autor"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="modelo.Categoria"%>
<%@page import="dao.CategoriaDAO"%>
<%@include file="../cabecalho.jsp" %>
<%
    String msg = "";
    String classe = "";
    CategoriaDAO cdao = new CategoriaDAO();
    AutorDAO adao = new AutorDAO();
    LivroDAO dao = new LivroDAO();
    EditoraDAO edao = new EditoraDAO();
    Livro obj = new Livro();
    
    if (request.getMethod().equals("POST")) {
        obj = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("codigo")));
        if (request.getParameter("txtNome") != null) {
            String[] autoresid = request.getParameter("autoreschk").split(";");
        //popular o livro
        //obj.setId(Integer.parseInt(request.getParameter("txtId")));
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
            c = cdao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("categoriaCombo")));
            obj.setCategoria(c);
        
            Editora e = new Editora();
            e = edao.buscarPorChavePrimaria(request.getParameter("editoraCombo"));
            obj.setEditora(e);
            
            Boolean resultado = dao.alterar(obj);
        
            if(resultado){
                msg = "Registro alterado com sucesso.";
                classe = "alert-success";
            }
            else{
                msg = "Não foi possível alterar.";
                classe = "alert-danger";
            }
        }
    }
    else {
        //e GET
        if (request.getParameter("codigo") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        
        obj = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("codigo")));

        if (obj == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    }
    
    

    
    //verifica se é postm ou seja, quer alterar
     

    List<Autor> autores = adao.listar();
    List<Editora> editoras = edao.listar();
    List<Categoria> categorias = cdao.listar();
%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema de Comércio Eletrônico
            <small>Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Área Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conteúdo de apresentação
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            Livro
        </div>
        <div class="panel-body">

            <div class="alert <%=classe%>">
                <%=msg%>
            </div>
            <form action="../UploadWS" method="post" enctype="multipart/form-data">

                <div class="col-lg-6">

                    <div class="form-group">
                        <label>Código</label>
                        <input class="form-control" type="text" name="txtCodigo" readonly value="<%=obj.getId()%>"/>
                    </div>

                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text"  name="txtNome"  required value="<%=obj.getNome()%>"/>
                    </div>

                    <div class="form-group">
                        <label>Preço</label>
                        <input class="form-control" type="text"  name="txtPreco"  required value="<%=obj.getPreco()%>"/>
                    </div>
                    <div class="form-group">
                        <label>Sinopse</label>
                        <textarea class="form-control"  name="txtSinopse"><%=obj.getSinopse()%>
                        </textarea>
                    </div>

                    <div class="form-group">
                        <label>Data Publicação</label>
                        <input class="form-control" type="text"  name="txtDatapublicacao" 
                               required value="<%=StormData.formata(obj.getDatapublicacao())%>"/>
                    </div>

                    <div class="form-group">
                        <label>Categoria</label>
                        <select name="categoriaCombo" class="form-control">
                            <option>Selecione</option>
                        <%
                         String selecionado;
                         for(Categoria c:categorias){
                             
                            if(obj.getCategoria().getId()==c.getId()){
                                selecionado="selected";
                            }
                            else{
                                selecionado="";
                            }
                            
                        %>
                        <option value="<%=c.getId()%>" <%=selecionado%>>
                            
                            
                        <%=c.getNome()%>
                        </option>
                        <%}%>
                        </select>
                    </div>
                        
                    <div class="form-group">
                        <label>Editora</label>
                        <select name="editoraCombo" class="form-control">
                            <option>Selecione</option>
                        <%
                         String sele;
                         for(Editora e:editoras){
                             
                            if(obj.getEditora().getCnpj()==e.getCnpj()){
                                sele="selected";
                            }
                            else{
                                sele="";
                            }
                            
                        %>
                        <option value="<%=e.getCnpj()%>" <%=sele%>>
                            
                            
                        <%=e.getNome()%>
                        </option>
                        <%}%>
                        </select>
                    </div>

                   <div class="form-group">
                        <label>Imagem 1</label>
                        <input type="file" name="arquivo1" id="arquivo1"  accept="image/*" />
                        <img src="../arquivos/<%=obj.getImagem1()%>" id="img1"/>
                        <input type="hidden" name="txtFotoVelha1" value="<%=obj.getImagem1()%>">
                   </div>

                    <div class="form-group">
                        <label>Imagem 2</label>
                        <input type="file" name="arquivo2" id="arquivo2"  accept="image/*" />
                        <img src="../arquivos/<%=obj.getImagem2()%>" id="img1"/>
                        <input type="hidden" name="txtFotoVelha2" value="<%=obj.getImagem2()%>">
                    </div>

                    <div class="form-group">
                        <label>Imagem 3</label>
                        <input type="file" name="arquivo3" id="arquivo3"  accept="image/*" />
                        <img src="../arquivos/<%=obj.getImagem3()%>" id="img1"/>
                        <input type="hidden" name="txtFotoVelha3" value="<%=obj.getImagem3()%>">
                    </div>
                    
                    <div class="form-group">
                        <label>Autores</label>

                        <%for (Autor a : autores) {
                            if(obj.getAutorList().contains(a)){
                                selecionado = "checked";
                            }
                            else{
                                selecionado = "";
                            }
                        %>
                        <input type="checkbox" name="autoreschk" value="<%=a.getId()%>" <%=selecionado%>><%=a.getNome()%>

                        <%}%>
                    </div>

                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
                
                </div>
            </form>

    </div>
</div>
<!-- /.row -->
    <%@include file="../rodape.jsp" %>
    
    <script>
    function readURL(input,destino) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#'+destino).attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#arquivo1").change(function(){
        readURL(this,"imagem1");
    });
</script>p" %>