<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<header class="container mx-auto py-4 border border-r-0 border-l-0 border-t-8 border-red-500">
        <img class="w-20" src="https://upload.wikimedia.org/wikipedia/commons/0/03/UFPS_Logo.png">
    </header>
	<div class="container mx-auto py-10s">
        <table class="min-w-full table-auto">
            <thead class="justify-between">
                <tr class="bg-gray-800">
                    <th class="px-16 py-2">
                        <span class="text-gray-300">id</span>
                    </th>
                    <th class="px-16 py-2">
                        <span class="text-gray-300">nombre</span>
                    </th>
                    <th class="px-16 py-2">
                        <span class="text-gray-300">fecha inicio</span>
                    </th>

                    <th class="px-16 py-2">
                        <span class="text-gray-300">fecha fin</span>
                    </th>

                    <th class="px-16 py-2">
                        <span class="text-gray-300">cargo</span>
                    </th>
                </tr>
            </thead>
            <tbody class="bg-gray-200">
                <tr class="bg-white border-4 border-gray-200">
                    <td>
                        <span class="text-center ml-2 font-semibold"><c:out value="${eleccion.id}"/></span>
                    </td>
                    <td class="px-16 py-2">
                        <span
                            class="bg-indigo-500 text-white px-4 py-2 border rounded-md hover:bg-white hover:border-indigo-500 hover:text-black ">
                           <c:out value="${eleccion.nombre}"/>
                        </span>
                    </td>
                    <td class="px-16 py-2">
                        <span><c:out value="${eleccion.fechainicio}"/></span>
                    </td>
                    <td class="px-16 py-2">
                        <span><c:out value="${eleccion.fechafin}"/></span>
                    </td>

                    <td class="px-16 py-2">
                        <span><c:out value="${eleccion.cargo}"/></span>
                    </td>
                    <td>
                    	<a class="hover:underline" href="delete?id=<c:out value='${eleccion.id}'/>">Eliminar</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>