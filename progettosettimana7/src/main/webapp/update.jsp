<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>INSERIRE NUOVO CONTATTO</h1><br>
        <form method="post" action="update.jsp">
        Inserire il proprio ID:<input type="text" name="id"><br>
        Nuovo nome:<input type="text" name="nome"><br>
        Nuovo cognome:<input type="text" name="nome"><br>
        Nuova mail:<input type="text" name="email"><br>

        <h1>INSERIRE NUOVI NUMERI</h1>
        <input type="hidden" name="operazione" value="update">
        Numero1: <input type="text" name="numero1"><br>
        Numero2: <input type="text" name="numero2"><br>
        <br>
        <input type="submit" value="aggiorna dati"><br>

        </form>
</body>
</html>