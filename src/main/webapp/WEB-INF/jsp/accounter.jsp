<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Accounter</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="../../recources/css/bootstrap.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="../../recources/css/navbar-fixed-top.css" />" rel="stylesheet">
    <link href="<c:url value="../../recources/css/doctor.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../recources/js/bootstrap.min.js"></script>
</head>

<body>

<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Теплопостачання</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/accounter">Лічильники</a></li>
                <li><a href="/customer">Користувачі</a></li>
                <li><a href="/building">Будинки</a></li>
                <li><a href="/map">Карта лічильників</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">
                    <button href="/" type="button" class="btn btn-default btn-sm">Вихід</button>
                </a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
    <button style="margin-left: 20%" data-toggle="modal"
            data-target="#addAccounter" class="btn btn-primary"
            type="button">Додати лічильник
    </button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Назва</th>
            <th>Тип</th>
            <th>Виробник</th>
            <th>Дата встановлення</th>

        </tr>

        </thead>
        <tbody>
        <c:forEach var="acounter" items="${accounters}">
            <%--onclick="window.location.href='/patient'; return false"--%>
            <tr>
                <td>${acounter.idAccounter}</td>
                <td>${acounter.nameAccounter}</td>
                <td>${acounter.accounterType.kind}</td>
                <td>${acounter.accProducer}</td>
                <td><fmt:formatDate value="${acounter.instalDate}" pattern="dd.MM.yyyy"/></td>
                <td>
                    <button style="margin: 0" class="btn btn-link" type="button"
                            data-toggle="modal"
                            data-target="#editEmployee">
                        <span class="glyphicon glyphicon-edit"></span>
                    </button>
                </td>
                <td>
                    <button style="margin: 0" data-toggle="modal"
                            data-target="#deleteEmployee" onclick="deleteAccounter('${acounter.idAccounter}')" class="btn btn-danger"
                            type="button">Видалити
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div id="addAccounter" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>

                <h4 class="modal-title">Додати лічильник</h4>

                <div>
                    <form method="post">
                        <table class="table">
                            <tr>
                                <td> Назва</td>
                                <td><input type="text" name="accounterName"></td>
                            </tr>
                            <tr>
                                <td> Виробник</td>
                                <td><input type="text" name="accounterProducer"></td>
                            </tr>
                            <tr>
                                <td> Дата встановлення</td>
                                <td><input type="text" name="instalDate"></td>
                            </tr>
                            <tr>
                                <div class="form-group">
                                    <label for="sel1">Тип:</label>
                                    <select class="form-control" name="accType" id="sel1">
                                        <c:forEach var="accType" items="${accTypes}">
                                            <option value="${accType.id}">${accType.kind}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </tr>
                        </table>

                        <div class="modal-footer">
                            <input type="SUBMIT" class="btn btn-default" value="Додати">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- modal dialog -->
<div id="editEmployee" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>

                <h4 class="modal-title">Edit employee</h4>

                <div>
                    <table class="table">
                        <tr>
                            <td> First Name</td>
                            <td><input type="text" ng-model="firstNameEdit" id="firstNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Second Name</td>
                            <td><input type="text" ng-model="secondNameEdit" id="secondNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Last Name</td>
                            <td><input type="text" ng-model="lastNameEdit" id="lastNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Email</td>
                            <td><input type="text" ng-model="emailEdit" id="emailEdit"></td>
                        </tr>
                        <tr>
                            <td> Role</td>
                            <td>
                                <input type="checkbox" id="techEdit" ng-model="techEdit" value="option1">
                                Tech </input>
                                <input type="checkbox" id="softEdit" ng-model="softEdit" value="option2">
                                Soft </input>
                                <input type="checkbox" id="adminEdit" ng-model="adminEdit" value="option3">
                                Administrator </input>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" ng-click="editEmployee()" type="button" id="saveChanges"
                        data-dismiss="modal">Save changes
                </button>
            </div>
        </div>

    </div>
</div>

</body>

<script>
    function deleteAccounter(id) {
        console.log('In delete' + id);
        document.location.href = 'deleteAccounters?id=' + id;
    }
</script>

    </html>
