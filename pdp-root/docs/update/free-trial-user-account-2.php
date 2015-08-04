<?php
$title = "Complete Free Trial User Account";
$category = "full-width";
include "header.php"
?>
<h1><?php echo $title ?></h1>
<form class="block" style="max-width:500px;" action="free-trial-user-account-3.php">
	<div>
		<div style="float:left; margin-right:1em;">
			<label for="billing-zipcode">Billing zipcode</label>
			<input type="text" name="billing-zipcode" id="billing-zipcode">
			<label for="billing-credit-card">Credit card</label>
			<input type="text" name="billing-credit-card" id="billing-credit-card"><br>
			<img src="img/credit-cards.jpg" alt="credit cards" style="margin-top:-10px;">
			<label for="billing-expiriation-month">Expiration Date</label>
			<select name="billing-expiriation-month" id="billing-expiriation-month">
				<option value="01">January</option>
				<option value="02">February</option>
				<option value="03">March</option>
				<option value="04">April</option>
				<option value="05">May</option>
				<option value="06">June</option>
				<option value="07">July</option>
				<option value="08">August</option>
				<option value="09">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
			</select>
			<select name="billing-expiriation-year" id="billing-expiriation-year">
				<?php
					$year = date('Y');
					$tenYears = $year + 10;
					$twoYears = $year + 2;
					for ($year; $year <= $tenYears; $year ++ ) {
						echo "<option value='" . $year . "'";
						if ($year == $twoYears) echo " selected='selected'";
						echo ">" . $year . "</option>";
					}
				?>
			</select>
			<label for="billing-name-on-card">Name on Card</label>
			<input type="text" name="billing-name-on-card" id="billing-name-on-card">
		</div>
		<div style="float:left;">
			<ul>
				<li id="billing-basic-container">
					<input type="radio" checked="checked" name="billing-account-type" id="billing-basic" value="basic">
					<label for="billing-basic">Basic Account</label>
					<ul>
						<li><input type="radio" checked="checked" name="billing-basic-type" value="monthly" id="billing-basic-monthly"><label for="billing-basic-monthly">$50 for month to month</label></li>
						<li><input type="radio" name="billing-basic-type" value="yearly" id="billing-basic-annual"><label for="billing-basic-annual">$480 for annual</label></li>
					</ul>
				</li>
				<li id="billing-premium-container">
					<input type="radio" name="billing-account-type" id="billing-premium" value="premium">
					<label for="billing-premium">Premium Account</label>
					<ul>
						<li><input type="radio" checked="checked" name="billing-premium-type" value="monthly" id="billing-premium-monthly"><label for="billing-premium-monthly">$80 for month to month</label></li>
						<li><input type="radio" name="billing-premium-type" value="yearly" id="billing-premium-annual"><label for="billing-premium-annual">$840 for annual</label></li>
					</ul>
				</li>
			</ul>
			<script>
			
				function disableInputs() {
					if ($("#billing-basic:checked").is(':checked')) {
						$("#billing-premium-container li input").prop('disabled', true);
						$("#billing-basic-container li input").prop('disabled', false);
						$("#billing-basic-container li label").removeClass("disabled");
						$("#billing-premium-container li label").addClass("disabled");
					}
					if ($("#billing-premium:checked").is(':checked')) {
						$("#billing-basic-container li input").prop('disabled', true);
						$("#billing-premium-container li input").prop('disabled', false);
						$("#billing-basic-container li label").addClass("disabled");
						$("#billing-premium-container li label").removeClass("disabled");
					}
				}
				disableInputs();
				$("input[name='billing-account-type']").click(function() {
					disableInputs();
				});
				
			</script>
		</div>
		<div class="clear"></div>
		<p>
			Your credit card will not be billed for the 14 -day free trial. If you cancel before your trial ends you will not be billed. If you want to keep your account after the trial, do nothing and you will be enrolled in the monthly or annual subscription that you selected.
		</p>
		<div style="text-align:center;">
			<button class="large">Start Free Access &rsaquo;</button>
		</div>
	</div>
</form>
<h2>Have Questions?</h2>
<dl>
	<dt>
		Why do you need my credit card if it's free?
	</dt>
	<dd>
		A credit card is required to prevent fraud and abuse of the free trial offer. Providing a valid credit card helps us verify that you are a real person and that you haven't previously signed up for a free trial.
	</dd>
	<dt>
		Will I be billed for the 14-day free trial?
	</dt>
	<dd>
		No, you will not be billed for the 14-day trial - it is absolutely free.
	</dd>
	<dt>
		What types of properties will I find in my selected market?
	</dt>
	<dd>
		Nationwide lists single family homes, condos/townhomes and multi-family properties in varies stages of Distressed, Renovated or Turn-Key investment property. In some markets, you may find a portfolio of homes being sold as a package. You will also find commercial properties on Nationwide is various markets.
	</dd>
	<dt>
		How do I contact customer service?
	</dt>
	<dd>
		You may contact customer service at xxx-xxx-xxxx anytime during business hours (Mon - Fri, 7AM - 6:30PM, Mountain Standard Time).
	</dd>
</dl>
<?php include "footer.php" ?>