<?php
$title = "Free Trial User Account";
include "header.php"
?>
<h1><?php echo $title ?></h1>
<p>To make an offer on this property and to see full details, create a user account.</p>
<table class="formatted shadow">
	<thead>
		<tr>
			<th></th>
			<th>
				Basic User Account FREE TRIAL<br><span style="font-family:arial; font-size:12pt">(for 14 days)</span>
			</th>
			<th>
				Premium User Account FREE TRIAL<br><span style="font-family:arial; font-size:12pt">(for 14 days)</span>
			</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>
				Features:
			</th>
			<td style="background:rgb(245,245,245);">
				<ul>
					<li>View Property Summary page</li>
					<li>Save and Rate your searches</li>
					<li>Notification of new properties</li>
					<li>Watch Properties and receive price updates</li>
				</ul>
			</td>
			<td>
				<ul>
					<li>Basic User AND:</li>
					<li>View detailed information on the property</li>
					<li>all Tabs including: Media &amp; Maps, Market, Attachments, Analysis</li>
					<li>Download professionally designed Property flyers</li>
					<li>more detailed advanced search capabilities</li>
					<li>Offer to buy shows you as a Premium User</li>
					<li>Professional offer</li>
					<li>Verified</li>
					<li>Proof of Funds</li>
					<li>Corporation</li>
					<li>Seasoned Investor</li>
				</ul>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<th>
				Cost:
			</th>
			<td style="line-height:1.25em;">
				<strong>As Low as $40 per month</strong><br>(after Trial Period)
			</td>
			<td style="line-height:1.25em;">
				<strong>As Low as $70 per month</strong><br>(after Trial Period)
			</td>
		</tr>
	</tfoot>
</table>
<p><strong>Ask about creating multiple users for your team.</strong></p>
<form class="block" action="free-trial-user-account-2.php">
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
	<label for="company-name">Company Name</label>
	<input type="text" name="company-name" id="company-name">
	<label for="address">Address</label>
	<input type="text" name="address" id="address">
	<label for="city">City</label>
	<input type="text" name="city" id="city">
	<label for="state">State</label>
	<input type="text" name="state" id="state">
	<label for="zip">Zip</label>
	<input type="text" name="zip" id="zip">
	<label for="country">Country</label>
	<input type="text" name="country" id="country">
	<label for="date-of-birth">Date of Birth</label>
	<input type="text" name="date-of-birth" id="date-of-birth">
	<label for="cash-buyer">Cash Buyer</label>
	<select name="cash-buyer" id="cash-buyer">
		<option value="yes">Yes</option>
		<option value="no">No</option>
	</select>
	<label for="prequalified-for-financing">Prequalififed for Financing</label>
	<select name="prequalified-for-financing" id="prequalified-for-financing">
		<option value="yes">Yes</option>
		<option value="no">No</option>
	</select>
	<label for="buyer-photograph">Buyer Photograph</label>
	<input type="file" name="buyer-photograph" id="buyer-photograph">
	<label for="first-name-of-agent">First Name of Agent</label>
	<input type="text" name="first-name-of-agent" id="first-name-of-agent">	
	<label for="last-name-of-agent">First Name of Agent</label>
	<input type="text" name="last-name-of-agent" id="last-name-of-agent">	
	<label for="email-address">Email Address</label>
	<input type="text" name="email-address" id="email-address">	
	<label for="phone-mobile">Email Address</label>
	<input type="text" name="phone-mobile" id="phone-mobile">	
	<label for="phone-office">Phone Office</label>
	<input type="text" name="phone-office" id="phone-office">
	<h2 style="margin-bottom:1em;">Premium User</h2>
	<label for="company-logo-upload">Company Logo upload</label>
	<input type="file" name="company-logo-upload" id="company-logo-upload">
	<br><br>
	<h3>Upload Resume or Bio</h3>
	<p>Please check all that apply and follow the instructions to upload.</p>
	<ul>
		<li>
			<input type="checkbox" name="user-resume" id="user-resume">
			<label for="user-resume">Resume</label>
		</li>
		<li>
			<input type="checkbox" name="user-linkedin-url" id="user-linkedin-url">
			<label for="user-linkedin-url">LinkedIn URL</label>
		</li>
		<li>
			<input type="checkbox" name="user-website-bio" id="user-website-bio">
			<label for="user-website-bio">Website Bio</label>
		</li>
	</ul>
	<label for="upload-resume-or-bio">Upload Resume or Bio</label>
	<input type="file" name="upload-resume-or-bio" id="upload-resume-or-bio">
	<br><br>
	<h3>Upload Proof of Funds</h3>
	<p>
		Please select all that apply and follow the instructions to upload.<br>
		<small>Please black out account numbers and any information that you do not want viewed by potential sellers.</small>
	</p>
	<ul>
		<li>
			<input type="checkbox" name="bank-statement" id="bank-statement">
			<label for="bank-statement">Bank Statement</label>
		</li>
		<li>
			<input type="checkbox" name="loan-commitment-letter" id="loan-commitment-letter">
			<label for="loan-commitment-letter">Loan Commitment Letter</label>
		</li>
		<li>
			<input type="checkbox" name="attorney-letter" id="attorney-letter">
			<label for="attorney-letter">Attorney Letter</label>
		</li>
		<li>
			<input type="checkbox" name="accountant-letter" id="accountant-letter">
			<label for="accountant-letter">Accountant Letter</label>
		</li>
		<li>
			<input type="checkbox" name="corporate-financing-statement" id="corporate-financing-statement">
			<label for="corporate-financing-statement">Corporate Financing Statement</label>
		</li>
		<li>
			<input type="checkbox" name="proof-of-funds-other" id="proof-of-funds-other">
			<label for="proof-of-funds-other">Other:</label>
			<input type="text" name="proof-of-funds-other-specify" id="proof-of-funds-other-specify">
		</li>
	</ul>
	<label for="upload-proof-of-funds">Upload Proof of Funds</label>
	<input type="file" name="upload-proof-of-funds" id="upload-proof-of-funds">	
	<br><br>
	<h3>Upload Corporate Documents</h3>
	<p>
		Please select all that apply and follow the instructions to upload.<br>
		<small>Please black out account numbers and any information that you do not want viewed by potential sellers.</small>
	</p>
	<ul>
		<li>
			<input type="checkbox" name="corporation-in-good-standing" id="corporation-in-good-standing">
			<label for="corporation-in-good-standing">Corporation in Good Standing</label>
		</li>
		<li>
			<input type="checkbox" name="articles-of-incorporation" id="articles-of-incorporation">
			<label for="articles-of-incorporation">Articles of Incorporation</label>
		</li>
		<li>
			<input type="checkbox" name="authorization-to-sign" id="authorization-to-sign">
			<label for="authorization-to-sign">Authorization to Sign</label>
		</li>
		<li>
			<input type="checkbox" name="corporate-documents-other" id="corporate-documents-other">
			<label for="corporate-documents-other">Other:</label>
			<input type="text" name="corporate-documents-other-specify" id="corporate-documents-other-specify">
		</li>
	</ul>
	<label for="upload-corporate-documents">Upload Corporate Documents</label>
	<input type="file" name="upload-corporate-documents" id="upload-corporate-documents">	
	<br><br>
	<h3>Upload Seasoned Investor Documents</h3>
	<p>
		Please select all that apply and follow the instructions to upload.<br>
		<small>Please black out account numbers and any information that you do not want viewed by potential sellers.</small>
	</p>
	<ul>
		<li>
			<input type="checkbox" name="current-list-of-properties-owed" id="current-list-of-properties-owed">
			<label for="current-list-of-properties-owed">Current list of properties owed</label>
		</li>
		<li>
			<input type="checkbox" name="previously-closed-hud" id="previously-closed-hud">
			<label for="previously-closed-hud">Previously closed HUD</label>
		</li>
		<li>
			<input type="checkbox" name="download-and-sign-affidavit-stating-second-investor" id="download-and-sign-affidavit-stating-second-investor">
			<label for="download-and-sign-affidavit-stating-second-investor">Download and sign affidavit stating seasoned investor</label>
		</li>
		<li>
			<input type="checkbox" name="seasoned-investor-documents-other" id="seasoned-investor-documents-other">
			<label for="seasoned-investor-documents-other">Other:</label>
			<input type="text" name="seasoned-investor-documents-other-specify" id="seasoned-investor-documents-other-specify">
		</li>
	</ul>
	<label for="upload-seasoned-investor-documents">Upload Seasoned Investor Documents</label>
	<input type="file" name="upload-seasoned-investor-documents" id="upload-seasoned-investor-documents">	
	<br><br>
	<h3>Upload Realtor / Broker Documents</h3>
	<p>
		Please select all that apply and follow the instructions to upload.<br>
		<small>Please black out account numbers and any information that you do not want viewed by potential sellers.</small>
	</p>
	<ul>
		<li>
			<input type="checkbox" name="current-list-of-properties-owed" id="current-list-of-properties-owed">
			<label for="current-list-of-properties-owed">Realtor/Broker LOGO</label>
		</li>
		<li>
			<input type="checkbox" name="previously-closed-hud" id="previously-closed-hud">
			<label for="previously-closed-hud">Copy of active license</label>
		</li>
		<li>
			<input type="checkbox" name="realtor-broker-resume" id="realtor-broker-resume">
			<label for="realtor-broker-resume">Resume</label>
		</li>
		<li>
			<input type="checkbox" name="realtor-broker-linkedin-url" id="realtor-broker-linkedin-url">
			<label for="realtor-broker-linkedin-url">LinkedIN URL</label>
		</li>
		<li>
			<input type="checkbox" name="realtor-broker-website-bio" id="realtor-broker-website-bio">
			<label for="realtor-broker-website-bio">Website Bio</label>
		</li>
		<li>
			<input type="checkbox" name="download-and-sign-affidavit-stating-buyer-representative" id="download-and-sign-affidavit-stating-buyer-representative">
			<label for="download-and-sign-affidavit-stating-buyer-representative">Download and Sign affidavit stating Buyer Representative</label>
		</li>
		<li>
			<input type="checkbox" name="upload-realtor-broker-documents-other" id="upload-realtor-broker-documents-other">
			<label for="upload-realtor-broker-documents-other">Other:</label>
			<input type="text" name="upload-realtor-broker-documents-other-specify" id="upload-realtor-broker-documents-other-specify">
		</li>
	</ul>
	<label for="upload-realtor-broker-documents">Upload Seasoned Investor Documents</label>
	<input type="file" name="upload-realtor-broker-documents" id="upload-realtor-broker-documents">	
	<br><br>
	<button class="right">Last Step &rsaquo;</button>
</form>
<?php include "footer.php" ?>