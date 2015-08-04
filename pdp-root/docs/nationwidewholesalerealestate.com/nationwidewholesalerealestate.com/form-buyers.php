<form id="form-registration" class="block">
	<h2>Register</h2>
	<label for="kind-of-buyer">What kind of buyer are you?</label>
	<select name="kind-of-buyer" id="kind-of-buyer">
		<option value="agent">Agent</option>
		<option value="first-time-investor">First Time Investor</option>
		<option value="seasoned-investor">Seasoned Investor</option>
		<option value="marketer">Marketer</option>
		<option value="broker">Broker</option>
	</select>
	<label for="first-name">First Name</label>
	<input type="text" name="first-name" id="first-name">
	<label for="first-name">Last Name</label>
	<input type="text" name="last-name" id="last-name">
	<label for="email">Email/Username</label>
	<input type="text" name="email" id="email">
	<label for="password">Password</label>
	<input type="text" name="password" id="password">
	<label for="password">Confirm Password</label>
	<input type="text" name="password-confirm" id="password-confirm">
	<label for="phone">Phone</label>
	<input type="text" name="phone" id="phone">
	<label>Your price range of properties</label>
	<select name="price-low" id="price-low">
		<option>$50,000</option>
		<option>$100,000</option>
		<option>$200,000</option>
		<option>$300,000</option>
		<option>$400,000</option>
		<option>$500,000</option>
		<option>$600,000</option>
		<option>$700,000</option>
		<option>$800,000</option>
		<option>$900,000</option>
		<option>$1,000,000</option>
	</select>
	<select name="price-high" id="price-high">
		<option>$50,000</option>
		<option>$100,000</option>
		<option>$200,000</option>
		<option>$300,000</option>
		<option>$400,000</option>
		<option>$500,000</option>
		<option>$600,000</option>
		<option>$700,000</option>
		<option>$800,000</option>
		<option>$900,000</option>
		<option>$1,000,000</option>
	</select>
	<label for="location-market-of-interest">Location/Market of Interest</label>
	<input type="text" name="location-market-of-interest" id="location-market-of-interest">
	<p style="font-size:10pt;">
		<label for="want-assistance" style="font-weight:normal; line-height:1.25em; font-size:11pt;"><input type="checkbox" name="want-assistance" id="want-assistance" style="margin:0;"> I would like assistance from a real estate professional.</label>
	</p>
	<p>
		<label for="want-financing" style="font-weight:normal; line-height:1.25em; font-size:11pt;"><input type="checkbox" name="want-financing" id="want-financing" style="margin:0;"> I would be interested in learning about financing options.</label>
	</p>
	<p>
		<label for="want-updates" style="font-weight:normal; line-height:1.25em; font-size:11pt;"><input type="checkbox" name="want-updates" id="want-updates" style="margin:0;" checked="checked"> Please email me updates and featured properties.</label>
	</p>
	<button>Register Now</button>
</form>