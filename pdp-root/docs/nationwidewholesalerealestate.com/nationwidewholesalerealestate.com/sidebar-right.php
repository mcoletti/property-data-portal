<section id="sidebar-right">
	<?php
		if ($category == "form-registration") include "form-registration.php";
		else if ($category == "form-buyers") include "form-buyers.php";
		else if ($category == "form-sellers") include "form-sellers.php";
		else {
	?>
			<div class="block">
				<strong>Register for More</strong>
				<p><em>Free and easy</em></p>
				<ul>
					<li>Save searches</li>
					<li>Notification of new properties</li>
					<li>Watch properties and receive price updates</li>
				</ul>
				<a class="button" href="register.php" style="float:right;">Register for Free</a>
			</div>
			<?php if ($category == "property") { ?>
				<div class="block">
					<strong>Financial Analysis</strong>
					<form>
						<p>
							Estimated monthly cash flow: $___
						</p>
						<p>
							Estimated Net Yield:  $___
						</p>
						<p>
							Possible investor financing as low as: $___
						</p>
					</form>
				</div>
			<?php } ?>
			<div class="block">
				<strong>Get financing</strong>
			</div>
			<div class="block">
				<strong>Recently Reduced Pricing</strong>
			</div>
	<?php } ?>
</section><!-- sidebar-right -->
