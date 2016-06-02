<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 31.05.2016
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!-- saved from url=(0077)https://datatables.net/extensions/buttons/examples/initialisation/export.html -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>DataTables example - File export</title>
    <link rel="shortcut icon" type="image/png" href="https://datatables.net/media/images/favicon.png">
    <link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="http://www.datatables.net/rss.xml">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/site-examples.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/buttons.dataTables.min.css">
    <style type="text/css" class="init">

    </style>
    <script type="text/javascript" async="" src="${ctx}/resources/js/ga.js"></script><script type="text/javascript" src="./DataTables example - File export_files/site.js">
    </script>
    <script type="text/javascript" src="${ctx}/resources/js/dynamic.php" async="">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/jquery-2.2.2.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/jquery.dataTables.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/dataTables.buttons.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/buttons.flash.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/jszip.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/pdfmake.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/vfs_fonts.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/buttons.html5.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/buttons.print.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="${ctx}/resources/js/demo.js">
    </script>
    <script type="text/javascript" class="init">
        $(document).ready(function() {
            $('#example').DataTable( {
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            } );
        } );
    </script>
</head>
<body class="wide comments example">
<div class="fw-container">
    <div class="fw-body">
        <div class="content">
            <table id="example" class="display nowrap dataTable" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
                <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 136px;">Name</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 216px;">Position</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 101px;">Office</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 42px;">Age</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 93px;">Start date</th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 79px;">Salary</th></tr>
                </thead>
                <tfoot>
                <tr><th rowspan="1" colspan="1">Name</th><th rowspan="1" colspan="1">Position</th><th rowspan="1" colspan="1">Office</th><th rowspan="1" colspan="1">Age</th><th rowspan="1" colspan="1">Start date</th><th rowspan="1" colspan="1">Salary</th></tr>
                </tfoot>
                <tbody>

                <tr role="row" class="odd">
                    <td class="sorting_1">Airi Satou</td>
                    <td>Accountant</td>
                    <td>Tokyo</td>
                    <td>33</td>
                    <td>2008/11/28</td>
                    <td>$162,700</td>
                </tr><tr role="row" class="even">
                    <td class="sorting_1">Angelica Ramos</td>
                    <td>Chief Executive Officer (CEO)</td>
                    <td>London</td>
                    <td>47</td>
                    <td>2009/10/09</td>
                    <td>$1,200,000</td>
                </tr><tr role="row" class="odd">
                    <td class="sorting_1">Ashton Cox</td>
                    <td>Junior Technical Author</td>
                    <td>San Francisco</td>
                    <td>66</td>
                    <td>2009/01/12</td>
                    <td>$86,000</td>
                </tr><tr role="row" class="even">
                    <td class="sorting_1">Bradley Greer</td>
                    <td>Software Engineer</td>
                    <td>London</td>
                    <td>41</td>
                    <td>2012/10/13</td>
                    <td>$132,000</td>
                </tr><tr role="row" class="odd">
                    <td class="sorting_1">Brenden Wagner</td>
                    <td>Software Engineer</td>
                    <td>San Francisco</td>
                    <td>28</td>
                    <td>2011/06/07</td>
                    <td>$206,850</td>
                </tr><tr role="row" class="even">
                    <td class="sorting_1">Brielle Williamson</td>
                    <td>Integration Specialist</td>
                    <td>New York</td>
                    <td>61</td>
                    <td>2012/12/02</td>
                    <td>$372,000</td>
                </tr><tr role="row" class="odd">
                    <td class="sorting_1">Bruno Nash</td>
                    <td>Software Engineer</td>
                    <td>London</td>
                    <td>38</td>
                    <td>2011/05/03</td>
                    <td>$163,500</td>
                </tr><tr role="row" class="even">
                    <td class="sorting_1">Caesar Vance</td>
                    <td>Pre-Sales Support</td>
                    <td>New York</td>
                    <td>21</td>
                    <td>2011/12/12</td>
                    <td>$106,450</td>
                </tr><tr role="row" class="odd">
                    <td class="sorting_1">Cara Stevens</td>
                    <td>Sales Assistant</td>
                    <td>New York</td>
                    <td>46</td>
                    <td>2011/12/06</td>
                    <td>$145,600</td>
                </tr><tr role="row" class="even">
                    <td class="sorting_1">Cedric Kelly</td>
                    <td>Senior Javascript Developer</td>
                    <td>Edinburgh</td>
                    <td>22</td>
                    <td>2012/03/29</td>
                    <td>$433,060</td>
                </tr></tbody>
            </table>
            <div class="dataTables_info" id="example_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div><div class="dataTables_paginate paging_simple_numbers" id="example_paginate"><a class="paginate_button previous disabled" aria-controls="example" data-dt-idx="0" tabindex="0" id="example_previous">Previous</a><span><a class="paginate_button current" aria-controls="example" data-dt-idx="1" tabindex="0">1</a><a class="paginate_button " aria-controls="example" data-dt-idx="2" tabindex="0">2</a><a class="paginate_button " aria-controls="example" data-dt-idx="3" tabindex="0">3</a><a class="paginate_button " aria-controls="example" data-dt-idx="4" tabindex="0">4</a><a class="paginate_button " aria-controls="example" data-dt-idx="5" tabindex="0">5</a><a class="paginate_button " aria-controls="example" data-dt-idx="6" tabindex="0">6</a></span><a class="paginate_button next" aria-controls="example" data-dt-idx="7" tabindex="0" id="example_next">Next</a></div></div>
        </div>
    </div>
<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-365466-5']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>

<div id="lbOverlay" style="display: none;">

</div>
<div id="lbCenter" style="display: none;">
    <div id="lbImage">
        <div style="position: relative;">
            <a id="lbPrevLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
            <a id="lbNextLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
        </div>
    </div>
</div>
<div id="lbBottomContainer" style="display: none;">
    <div id="lbBottom">
        <a id="lbCloseLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
        <div id="lbCaption">

        </div>
        <div id="lbNumber">

        </div>
        <div style="clear: both;">
        </div>
    </div>
</div>
</body></html>
