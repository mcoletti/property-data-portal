			</content>
			<?php
				if ($category !== "full-width" && $category !== "form-registration") {
					include "sidebar-right.php";
				}
			?>
			<?php
				if ($category == "form-registration") {
					include "form-registration.php";
				}
			?>
		</section><!-- content -->
		<section id="footer">
			<footer>
				<ul>
					<li><a href="index.php">Home</a></li>
					<li><a href="how-it-works.php">How it Works</a></li>
					<li><a href="buyers.php">Buyers</a></li>
					<li><a href="sellers.php">Sellers</a></li>
					<li><a href="agents-brokers.php">Agents-Brokers</a></li>
					<li><a href="news.php">News</a></li>
					<li><a href="financing.php">Financing</a></li>
					<li><a href="property-managers.php">Property Managers</a></li>
					<li><a href="insurance.php">Insurance</a></li>
					<li><a href="ira.php">IRA's</a></li>
					<li><a href="contractors.php">Contractors</a></li>
					</li>
				</ul>
				<p id="copyright">Copyright &copy; <?php echo date('Y') ?></p>
			</footer>
		</section><!-- footer -->
	</body>
</html>