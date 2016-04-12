<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>Upload File</h2>



<h1>Upload File</h1>

        <form method="POST" action="<c:url value='/files/upload' />" enctype="multipart/form-data" class="form-horizontal">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Upload a file</label>
                    <div class="col-md-7">
                        <input type="file" name="file" id="file" class="form-control input-sm"/>
                        <div class="has-error">
                           ...
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form>


</body>
</html>
