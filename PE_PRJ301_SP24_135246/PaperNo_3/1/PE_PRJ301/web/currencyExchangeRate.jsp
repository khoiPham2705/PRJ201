<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Exchange</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        header {
            background-color: #333;
            padding: 10px;
            color: #fff;
            text-align: center;
        }

        nav {
            margin-bottom: 20px;
        }

        nav a {
            text-decoration: none;
            color: #333;
            padding: 10px;
            margin-right: 10px;
            border-radius: 5px;
            background-color: #eee;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>

<body>
    <header>
        <h1>Currency Exchange Rates</h1>
    </header>

    <nav>

        <a href="#">Currency List</a>
        <a href="#">Hello ${user.name}  </a>
        <a href="MainController?action=logout">Logout</a>
    </nav>
    
    <form id="searchForm" action="MainController">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="SearchCode">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="SearchCode">
        <input type ="hidden" name ="action" value ="search"/> 
        <input type="submit" value="Search" >
    </form>

        <c:if test="${not empty currencyList}">
    <table border="1">
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Description</th>
            <th>Rate</th>
        </tr>
        <c:forEach var="currency" items="${currencyList}">
            <tr>
                <td>${currency.code}</td>
                <td>${currency.name}</td>
                <td>${currency.description}</td>
                <td>${currency.rate}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    <table>
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Description</th>
                <th>Rate</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>USD</td>
                <td>US Dollar</td>
                <td>United States Dollar</td>
                <td>1.00</td>
            </tr>
            <tr>
                <td>EUR</td>
                <td>Euro</td>
                <td>European Union Currency</td>
                <td>0.85</td>
            </tr>
            <!-- Add more currency rows as needed -->
        </tbody>
    </table>
</body>

</html>