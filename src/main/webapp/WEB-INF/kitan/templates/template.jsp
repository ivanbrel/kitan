<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <tiles:insertAttribute name="inHeader"/>
    <title><tiles:getAsString name="titleKey"/></title>
    <link href="${ctx}/resources/img/logo.png" rel="shortcut icon">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="content"/>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>

<!-- jQuery -->
<script src="${ctx}/resources/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${ctx}/resources/bootstrap/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${ctx}/resources/bootstrap/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="${ctx}/resources/bootstrap/vendors/nprogress/nprogress.js"></script>
<!-- Datatables -->
<script src="${ctx}/resources/bootstrap/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/jszip/dist/jszip.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="${ctx}/resources/bootstrap/vendors/pdfmake/build/vfs_fonts.js"></script>
<script src="${ctx}/resources/js/tableExport.js"></script>

<!-- Custom Theme Scripts -->
<script src="${ctx}/resources/bootstrap/js/custom.min.js"></script>

<script src="${ctx}/resources/js/ekko-lightbox.min.js"></script>

<script src="${ctx}/resources/js/fileinput.min.js"></script>

<!-- Datatables -->
<script>
    $(document).ready(function() {
        var handleDataTableButtons = function() {
            if ($("#datatable-buttons").length) {
                $("#datatable-buttons").DataTable({
                    dom: "Bfrtip",
                    buttons: [
                        {
                            extend: "copy",
                            className: "btn-sm"
                        },
                        {
                            extend: "csv",
                            className: "btn-sm"
                        },
                        {
                            extend: "excel",
                            className: "btn-sm"
                        },
                        {
                            extend: "pdfHtml5",
                            className: "btn-sm"
                        },
                        {
                            extend: "pdf",
                            className: "btn-sm"
                        },
                        {
                            extend: "print",
                            className: "btn-sm"
                        },
                    ],
                    responsive: true
                });
            }
        };

        TableManageButtons = function() {
            "use strict";
            return {
                init: function() {
                    handleDataTableButtons();
                }
            };
        }();

        $('#datatable').dataTable();
        $('#datatable-keytable').DataTable({
            keys: true
        });

        $('#datatable-responsive').DataTable();

        $('#datatable-scroller').DataTable({
            ajax: "js/datatables/json/scroller-demo.json",
            deferRender: true,
            scrollY: 380,
            scrollCollapse: true,
            scroller: true
        });

        var table = $('#datatable-fixed-header').DataTable({
            fixedHeader: true
        });

        TableManageButtons.init();
    });
</script>

<%--Image popup--%>
<script>
    $(document).ready(function ($) {
        // delegate calls to data-toggle="lightbox"
        $(document).delegate('*[data-toggle="lightbox"]:not([data-gallery="navigateTo"])', 'click', function (event) {
            event.preventDefault();
            return $(this).ekkoLightbox({
                onShown: function () {
                    if (window.console) {
                        return console.log('show image');
                    }
                },
                onNavigate: function (direction, itemIndex) {
                    if (window.console) {
                        return console.log('Navigating ' + direction + '. Current item: ' + itemIndex);
                    }
                }
            });
        });

        //Programatically call
        $('#open-image').click(function (e) {
            e.preventDefault();
            $(this).ekkoLightbox();
        });
        $('#open-youtube').click(function (e) {
            e.preventDefault();
            $(this).ekkoLightbox();
        });

        // navigateTo
        $(document).delegate('*[data-gallery="navigateTo"]', 'click', function (event) {
            event.preventDefault();

            var lb;
            return $(this).ekkoLightbox({
                onShown: function () {

                    lb = this;

                    $(lb.modal_content).on('click', '.modal-footer a', function (e) {

                        e.preventDefault();
                        lb.navigateTo(2);

                    });

                }
            });
        });
    });
</script>

<%--file upload--%>
<script>
    $("#file-3").fileinput({
        showUpload: false,
        showCaption: false,
        browseClass: "btn btn-primary btn-lg",
        fileType: "any",
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
    });
    $(".btn-warning").on('click', function() {
        if ($('#file-4').attr('disabled')) {
            $('#file-4').fileinput('enable');
        } else {
            $('#file-4').fileinput('disable');
        }
    });
    $(".btn-info").on('click', function() {
        $('#file-4').fileinput('refresh', {previewClass:'bg-info'});
    });
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
    });
</script>
</body>
</html>
