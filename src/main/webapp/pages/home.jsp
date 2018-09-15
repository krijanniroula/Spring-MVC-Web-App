<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Web Application</title>

</head>
<body>
	<div id="get" style="margin-top: 200px; margin-left: 389px;">
		<input type="button" value="Get zones" id="getZones"> <input
			type="button" value="Get districts" id="getDistricts"
			style="margin-left: 21px;"> <input type="button"
			value="Get both" id="getBoth" style="margin-left: 13px;">
	</div>
	<div id="select" style="margin-top: 23px; margin-left: 389px;">
		<select id="enum_zone">

			<option value="zone" selected>Select Zone</option>

		</select> <select id="enum_district">

			<option value="district" selected>Select District</option>

		</select>
	</div>
	<div id="test"></div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function zonerequest() {
			var z = '{"keyword":["zone"]}';
			$.ajax({
				url : "/getZoneCategories",
				data : z,
				type : "POST",
				dataType : "json",
				contentType : 'application/json'
			});

			$.ajax({
				type : "GET",
				url : "/getZoneCategories",
				dataType : "json",
				success : function(data) {
					console.log(data);

					$.each(data, function(key, value) {
						for (var i = 0; i < value.length; i++) {
							$('#enum_zone').append(
									'<option value="' + key + '">' + value[i]
											+ '</option>');
						}

					});
				}
			});
		}

		function districtrequest() {
			var z = '{"keyword":["district"]}';
			$.ajax({
				url : "/getDistrictCategories",
				data : z,
				type : "POST",
				dataType : "json",
				contentType : 'application/json'
			});

			$.ajax({
				type : "GET",
				url : "/getDistrictCategories",
				dataType : "json",
				success : function(data) {
					console.log(data);

					$.each(data, function(key, value) {
						for (var i = 0; i < value.length; i++) {
							$('#enum_district').append(
									'<option value="' + key + '">' + value[i]
											+ '</option>');
						}

					});
				}
			});
		}
		
		function bothrequest() {
			var z = '{"keyword":["zone","district"]}';
			$.ajax({
				url : "/getBothCategories",
				data : z,
				type : "POST",
				dataType : "json",
				contentType : 'application/json'
			});

			$.ajax({
				type : "GET",
				url : "/getBothCategories",
				dataType : "json",
				success : function(data) {
					console.log(data);

					$.each(data,function(key1,body){
						
						$.each(body[0], function(key, value) {
							for (var i = 0; i < value.length; i++) {
								$('#enum_zone').append(
										'<option value="' + key + '">' + value[i]
												+ '</option>');
							}

						}),
						
						$.each(body[1], function(key, value) {
							for (var i = 0; i < value.length; i++) {
								$('#enum_district').append(
										'<option value="' + key + '">' + value[i]
												+ '</option>');
							}

						});
					
					});
					
				}
			});
		}

		$('#getZones').one("click", function() {
			$('#enum_zone').children('option:not(:first)').remove();
			zonerequest();
		});

		$('#getDistricts').one("click", function() {
			$('#enum_district').children('option:not(:first)').remove();
			districtrequest();

		});

		$('#getBoth').one("click", function() {
			$('#enum_zone').children('option:not(:first)').remove();
			$('#enum_district').children('option:not(:first)').remove();
			bothrequest();
		});
	</script>

</body>
</html>