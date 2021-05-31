<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación Gestión de candidatos</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
	<header class="container mx-auto py-4 border border-r-0 border-l-0 border-t-8 border-red-500">
        <a href="">
            <img class="w-20" src="https://upload.wikimedia.org/wikipedia/commons/0/03/UFPS_Logo.png">
        </a>
        <ul class="flex mt-4">
            <a class="mr-8 hover:underline" href="/registrar-candidato">Registrar candidato</a>
            <a class="mr-8 hover:underline" href="/registrar-eleccion">Registrar elección</a>
            <a class="mr-8 hover:underline" href="/listar">Lista candidato</a>
        </ul>
    </header>
    
    <c:if test="${candidato != null}">
    	<h1 class="text-3xl text-center my-8">Editar candidato</h1>
    </c:if>
	<c:if test="${candidato == null}">
    	<h1 class="text-3xl text-center my-8">Registro de candidato</h1>
    </c:if>
    <c:if test="${candidato != null}">
		<form class="mx-auto w-full max-w-lg my-8" action="update" method="post">
	</c:if>
	<c:if test="${candidato == null}">
		<form class="mx-auto w-full max-w-lg my-8" action="insert" method="post">
	</c:if>
		<c:if test="${candidato != null}">
			<input required type="text" name="id" value="<c:out value='${candidato.id }'/>" />
		</c:if>
        <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
                    Documento
                </label>
                <input
                    class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-password" type="text" name="documento" placeholder="10912233445" value="<c:out value='${candidato.documento}'/>">
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-4">
            <div class="w-full px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
                    Nombre
                </label>
                <input
                    class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-city" type="text" name="nombre"  value="<c:out value='${candidato.nombre}'/>">
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-4">
            <div class="w-full px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
                    Apellido
                </label>
                <input
                    class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-city" name="apellido"  type="text"value="<c:out value='${candidato.apellido}'/>">
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-8">
            <div class="w-full px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-zip">
                    Eleccion
                </label>
                <input
                    class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-zip" type="text" name="eleccion"  value="<c:out value='${candidato.eleccion }'/>">
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-8">
            <div class="w-full px-3 mb-6 md:mb-0">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-zip">
                    Numero
                </label>
                <input
                    class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-zip" type="text" name="numero"  value="<c:out value='${candidato.numero }'/>">
            </div>
        </div>
        <div class="md:flex md:items-center">
            <div class="md:w-1/3"></div>
            <div class="md:w-2/3">
              <input class="shadow bg-red-500 hover:bg-red-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded" type="submit"
                value="Registrar candidato"
              />
            </div>
          </div>
    </form>
</body>
</html>