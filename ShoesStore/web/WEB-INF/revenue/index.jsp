<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi-VN"/>

<div class="row">
    <div class="col-sm-4">
        <h2>Revenue by Date</h2>
        <br/>
        <form action="<c:url value="/revenue/get.do" />">
            Date:
            <input type="date" name="date" required="" value="${param.type == 'date'?param.date:null}">
            <button type="submit" name="type" value="date">Go</button>
        </form>

        <c:if test="${param.type == 'date' and not empty rev.revenue}">
            Revenue: <fmt:formatNumber type="currency" value="${rev.revenue}" />
        </c:if>
    </div>

    <div class="col-sm-4">
        <h2>Revenue by Month</h2>
        <br/>
        <form action="<c:url value="/revenue/get.do" />">
            Month:
            <input type="month" name="month" required="" value="${param.month}">
            <button type="submit" name="type" value="month">Go</button>
        </form>

        <c:if test="${param.type == 'month' and not empty rev.revenue}">
            Revenue: <fmt:formatNumber type="currency" value="${rev.revenue}" />
        </c:if>
    </div>

    <div class="col-sm-4">
        <h2>Revenue by Year</h2>
        <br/>
        <form action="<c:url value="/revenue/get.do" />">
            Year:
            <input type="number" name="year" min="2020" max="2026" required="" value="${param.year}">
            <button type="submit" name="type" value="year">Go</button>
        </form>

        <c:if test="${param.type == 'year' and not empty rev.revenue}">
            Revenue: <fmt:formatNumber type="currency" value="${rev.revenue}" />
        </c:if>
    </div>
</div>

<br/>

<div class="row">
    <div class="col-sm-3">
        <h2>7-Day Revenue</h2>
        <br/>
        <form action="<c:url value="/revenue/get.do" />">
            Anchor Date: <br/>
            <input type="date" name="date" required="" value="${param.type == '7days'?param.date:null}">
            <button type="submit" name="type" value="7days">Go</button>
        </form>
    </div>

    <div class="col-sm-9">

        <canvas id="revenueChart"></canvas>

        <c:if test="${not empty revList}">
            <script>
                // Extract labels and data
                const labels = [];
                const data = [];
                <c:forEach var="item" items="${revList}">
                labels.push('${item.day}/${item.month}/${item.year}');
                    data.push(${item.revenue});
                </c:forEach>
                    
                // Create the chart
                const ctx = document.getElementById('revenueChart').getContext('2d');
                const revenueChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Revenue',
                            data: data,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)',
                                'rgba(255, 99, 132, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)',
                                'rgba(255, 99, 132, 1)'
                            ],
                            borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            </script>
        </c:if>
    </div>
</div>

<i>${message}</i>