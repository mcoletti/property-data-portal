<?php
$title = "Search Results";
$category = "full-width";
?>
<?php include "header.php"
?>
<h1>Search Results for "Lorem Ipsum"</h1>
<a href="#" id="advanced-search-toggle">Advanced Search</a>
<div id="advanced-search">
	<form>
		<div style="display:table-cell; width:800px; vertical-align:top;">
			<div>
				<strong>Price</strong>
				<input type="text" name="price-min" placeholder="min" style="width:2em;">
				to
				<input type="text" name="price-max" placeholder="max" style="width:2em;">
				<strong>Bedrooms</strong>
				<input type="text" name="bedrooms" placeholder="any" style="width:2em;">
				<strong>Bathrooms</strong>
				<input type="text" name="bathrooms" placeholder="any" style="width:2em;">
				<strong>Square Feet</strong>
				<input type="text" name="square-feet-min" placeholder="any" style="width:3em;">
				to
				<input type="text" name="square-feet-max" placeholder="any" style="width:3em;">
				<strong>Year Built</strong>
				<input type="text" name="year-built-min" placeholder="any" style="width:2em;">
				to
				<input type="text" name="year-built-max" placeholder="any" style="width:2em;">
			</div>
			<div>
				<strong>Listing Type</strong>
				<ul>
					<li>
						<input type="checkbox" name="listing-type-any" id="listing-type-any">
						<label for="listing-type-any">Any</label>
					</li>
					<li>
						<input type="checkbox" name="listing-type-distressed" id="listing-type-distressed">
						<label for="listing-type-distressed">Distressed</label>					
					</li>
					<li>
						<input type="checkbox" name="listing-type-renovated" id="listing-type-renovated">
						<label for="listing-type-renovated">Renovated</label>
					</li>
					<li>
						<input type="checkbox" name="listing-type-renovated-rented" id="listing-type-renovated-rented">
						<label for="listing-type-renovated-rented">Renovated &amp; Rented</label>		
					</li>
				</ul>
				<strong>Rental Type</strong>
				<ul>
					<li>
						<input type="checkbox" name="rental-type-section-8" id="rental-type-section-8">
						<label for="rental-type-section-8">Section 8</label>
					</li>
					<li>
						<input type="checkbox" name="rental-open-market" id="rental-open-market">
						<label for="rental-open-market">Open Market</label>
					</li>
					<li>
						<input type="checkbox" name="rental-type-rent-to-own" id="rental-type-rent-to-own">
						<label for="rental-type-rent-to-own">Rent to Own</label>
					</li>
					<li>
						<input type="checkbox" name="rental-type-land-contract" id="rental-type-land-contract">
						<label for="rental-type-land-contract">Land Contract</label>
					</li>
				</ul>
			</div>
			<div>
				<strong>Residential Listings</strong>
				<ul>
					<li>
						<input type="checkbox" name="residential-listings-all" id="residential-listings-all">
						<label for="residential-listings-all">All Residential</label>
					</li>
					<li>
						<input type="checkbox" name="residential-listings-studio" id="residential-listings-studio">
						<label for="residential-listings-studio">Studio</label>					
					</li>
					<li>
						<input type="checkbox" name="residential-listings-single-family" id="residential-listings-single-family">
						<label for="residential-listings-single-family">Single Family</label>
					</li>
					<li>
						<input type="checkbox" name="residential-listings-multi-family-4" id="residential-listings-multi-family-4">
						<label for="residential-listings-multi-family-4">Multi Family (2-4 units)</label>		
					</li>
					<li>
						<input type="checkbox" name="residential-listings-multi-family-5" id="residential-listings-multi-family-5">
						<label for="residential-listings-multi-family-5">Multi Family (5+ Units)</label>
					</li>
					<li>
						<input type="checkbox" name="residential-listings-condo-tnhm" id="residential-listings-condo-tnhm">
						<label for="residential-listings-condo-tnhm">Condo/TNhm</label>					
					</li>
					<li>
						<input type="checkbox" name="residential-listings-mobile-home" id="residential-listings-mobile-home">
						<label for="residential-listings-mobile-home">Mobile Home</label>
					</li>
					<li>
						<input type="checkbox" name="residential-listings-land" id="residential-listings-land">
						<label for="residential-listings-land">Land</label>		
					</li>
				</ul>
			</div>
			<div>
				<strong>Commercial Properties</strong>
				<ul>
					<li>
						<input type="checkbox" name="commercial-properties-all" id="commercial-properties-all">
						<label for="commercial-properties-all">All Commercial</label>
					</li>
					<li>
						<input type="checkbox" name="commercial-properties-office" id="commercial-properties-office">
						<label for="commercial-properties-office">Office</label>					
					</li>
					<li>
						<input type="checkbox" name="commercial-properties-retail" id="commercial-properties-retail">
						<label for="commercial-properties-retail">Retail</label>
					</li>
					<li>
						<input type="checkbox" name="commercial-properties-warehouse-industrial" id="commercial-properties-warehouse-industrial">
						<label for="commercial-properties-warehouse-industrial">Warehouse/Industrial</label>		
					</li>
					<li>
						<input type="checkbox" name="commercial-properties-mixed-use" id="commercial-properties-mixed-use">
						<label for="commercial-properties-mixed-use">Mixed Use</label>		
					</li>
				</ul>
				<strong>Listing Status</strong>
				<ul>
					<li>
						<input type="checkbox" name="listing-status-all" id="listing-status-all">
						<label for="listing-status-all">All</label>
					</li>
					<li>
						<input type="checkbox" name="listing-status-under-review" id="listing-status-under-review">
						<label for="listing-status-under-review">Under Review</label>
					</li>
					<li>
						<input type="checkbox" name="listing-status-under-contract" id="listing-status-under-contract">
						<label for="listing-status-under-contract">Under Contract</label>
					</li>
					<li>
						<input type="checkbox" name="listing-status-active" id="listing-status-active">
						<label for="listing-status-active">Active</label>
					</li>
				</ul>
			</div>
				<a style="float:right; line-height:1.4em !importan; margin-right:1em;"><button style="line-height:1.5em !important;">Save Search</button><span style="font-size:9pt; margin-right:1em;"><br>(premium members)</a>
				<a class="button" style="float:right; margin-right:.5em;">Free Search</a>
		</div>
		<div style="display:table-cell">
			<div style="background:white; border-radius:2px; padding:20px; float:right; margin-right:0;" class="shadow">
				<h3 style="margin-top:0;">Premium Search</h3>
				<strong>Show Only</strong>
				<ul>
					<li>
						<input type="checkbox" name="show-only-reduced-price" id="show-only-reduced-price">
						<label for="show-only-reduced-price">Reduced Price</label>
					</li>
					<li>
						<input type="checkbox" name="show-only-featured-properties" id="show-only-featured-properties">
						<label for="show-only-featured-properties">Featured Properties</label>
					</li>
					<li>
						<input type="checkbox" name="show-only-financing-offered" id="show-only-financing-offered">
						<label for="show-only-financing-offered">Financing Offered</label>
					</li>
					<li>
						<input type="checkbox" name="show-only-photos-available" id="show-only-photos-available">
						<label for="show-only-photos-available">Photos Available</label>
					</li>
					<li>
						<input type="checkbox" name="show-only-video-walk-thru" id="show-only-video-walk-thru">
						<label for="show-only-video-walk-thru">Video Walk Thru</label>
					</li>
					<li>
						<input type="checkbox" name="show-only-bulk-re-portfolio" id="show-only-bulk-re-portfolio">
						<label for="show-only-bulk-re-portfolio">Bulk RE Portfolio</label>
					</li>
				</ul>
				<strong>Net Yield</strong>
				<select>
					<option value="8">8% +</option>
					<option value="9">9% +</option>
					<option value="10">10% +</option>
					<option value="11">11% +</option>
					<option value="12">12% +</option>
					<option value="13">13% +</option>
					<option value="14">14% +</option>
					<option value="15">15% +</option>
					<option value="16">16% +</option>
				</select>
				<strong>Listing Date</strong>
				<select>
					<option value="any">Any</option>
					<option value="today">Today</option>
					<option value="days-7">Within last 7 days</option>
					<option value="days-14">Within last 14 days</option>
					<option value="days-30">Within last 30 days</option>
					<option value="days-60">Within last 60 days</option>
					<option value="days-90">Within last 90 days</option>
					<option value="days-120">Within last 120 days</option>
					<option value="months-6">Within last 6 months</option>
					<option value="months-12">Within last 12 months</option>
					<option value="months-24">Within last 24 months</option>
					<option value="months-36">Within last 36 months</option>
				</select>
				<br>
				<a href="#" class="button" style="margin-top:1em;">Try Premium Search</a>
			</div>
		</div>
	</form>
	<div style="clear"></div>
</div><!-- advanced-search -->
<div class="sort">
	<label for="sort-by">Sorty By: </label>
	<select id="sort-by" name="sorty-by">
		<option value="featured">Featured</option>
		<option value="featured">Price (high to low)</option>
		<option value="featured">Price (low to high)</option>
	</select>
</div>
<div class="clear"></div>
<ul class="search-results">
	<?php include "demo-listings.php" ?>
</ul>
<?php include "footer.php"
?>