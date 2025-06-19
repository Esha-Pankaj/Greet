<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #3AAFA9">
		<div>
			<a class="navbar-brand" style="font-size:25px">Bug Tracker</a>
		</div>
		<ul class="navbar-nav">
		<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" style="color: black;font-size:18px">Bug List</a></li>
		</ul>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link" style="color: black; font-weight:bold;font-size:18px">Logout</a></li>
					
		</ul>
	</nav>
</header>