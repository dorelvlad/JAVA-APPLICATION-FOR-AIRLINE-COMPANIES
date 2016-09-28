
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/jpaStyles1.css" />
</head>
<body>
	<h1 style="text-decoration: underlilne;">Forms</h1>
	<h3>Add Flight and Airplane</h3>
	<form method="post" action="AddFlight">
		<h4>Flight</h4>
		From <select id="from_destination" name="from_destination">
			<option value="San_Francisco">San Francisco</option>
			<option value="Los_Angeles">Los Angeles</option>
			<option value="New_York">New York</option>
			<option value="Washington_DC">Washington DC</option>
			<option value="London">London</option>
			<option value="Paris">Paris</option>
			<option value="Rome">Rome</option>
			<option value="Amsterdam">Amsterdam</option>
		</select> <br /> <br /> To <select id="to_destination" name="to_destination">
			<option value="San_Francisco">San Francisco</option>
			<option value="Los_Angeles">Los Angeles</option>
			<option value="New_York">New York</option>
			<option value="Washington_DC">Washington DC</option>
			<option value="London">London</option>
			<option value="Paris">Paris</option>
			<option value="Rome">Rome</option>
			<option value="Amsterdam">Amsterdam</option>
		</select> <br /> <br />
		<hr />
		<h4>Time of Flight</h4>

		Year: <select name="year">
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
		</select> <br /> <br /> Month: <select name="month">
			<option value="0">January</option>
			<option value="1">February</option>
			<option value="2">March</option>
			<option value="3">April</option>
			<option value="4">May</option>
			<option value="5">June</option>
			<option value="6">July</option>
			<option value="7">August</option>
			<option value="8">September</option>
			<option value="9">October</option>
			<option value="10">November</option>
			<option value="11">December</option>
		</select> <br /> <br /> Day of month: <input type="text" name="day_of_month" />
		<br /> <br /> Hour of day(0-23): <input type="text"
			name="hour_of_day" /> <br /> <br /> Minute(1-59): <input
			type="text" name="minute" /> <br /> <br /> Price: <input
			type="text" name="price" /> <br /> <br />

		<hr />
		<h4>Airplane</h4>
		PlaneMake: <input type="text" name="planemake" /> <br /> <br />
		Model Name: <input type="text" name="model_name" /> <br /> <br />
		Seating capacity: <input type="text" name="seating_capacity" /> <br />
		<br />
		<hr />
		<button type="submit">Add Flight and Airplane</button>
	</form>

	<h3>Add pilot to flight</h3>
	<form method="post" action="CreatePilotAndAddToFlight">
		<h4>Pilot</h4>
		First Name: <input type="text" name="first_name" /> <br /> <br />
		Last Name: <input type="text" name="last_name" /> <br /> <br />
		License: <input type="text" name="license" /> <br /> <br /> Pilot
		Rank: <select name="pilot_rank">
			<option value="Captain">Captain</option>
			<option value="Second_Officer">Second Officer</option>
			<option value="Junior_Officer">Junior Officer</option>
		</select> <br /> <br /> Flight id: <input type="text" name="fId" />
		<hr />
		<button type="submit">Add pilot to Flight</button>

	</form>

	<h3>Add passenger</h3>
	<form method="post" action="AddPassenger">
		First Name: <input type="text" name="pfirst_name" /> <br /> <br />
		Last Name: <input type="text" name="plast_name" /> <br /> <br />
		Date of Birth: <input type="text" name="dob" /> <br /> <br />
		Gender: <select name="gender">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
		</select>
		<hr />
		<button type="submit">Add Passenger</button>
	</form>
	
	
	<h3>Add passenger to Flight</h3>
	<form method="post" action="AddPassengerToFlight">
		Add a passenger with an id of <input type="text" name="pid" /> To
		a flight with an id of <input type="text" name="fid" /> <br /> <br />
		<hr />
		<button type="submit">Add passenger to a Flight</button>
	</form>
	
	<h3>
	        Add flight to passenger<span style="font-size: 16px; vertical-aligne: middle;">(give a
			passenger another flight ticket to his/her collection of flight
			tickets)</span>
	</h3>
	<form method="post" action="AddFlightTicketToPassenger">
		Add tickets to the flight with an id of <input type="text" name="fid" />to
		a passanger with an id of <input type="text" name="pid" /> <br />
		<br /> <span style="font-weight: bold;">(In real world terms
			add the flight ticket to his/her collection of flight tickets)</span>
		<hr />
		<button type="submit">Add Flight (ticket )to passanger's
			flight tickets</button>
	</form>
</body>
</html>