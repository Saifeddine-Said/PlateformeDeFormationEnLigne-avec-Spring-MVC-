/* ========================================================================
 * email.js
 * Page/renders: page-email.html
 * Plugins used: summernote, gritter, selectize
 * ======================================================================== */

'use strict';

(function(factory) {
	if (typeof define === 'function' && define.amd) {
		define([ 'magnific', 'selectize', 'gritter', 'summernote' ], factory);
	} else {
		factory();
	}
}
		(function() {

			$(function() {
				// Gritter
				// ================================
				setTimeout(
						function() {
							$.gritter
									.add({
										title : 'Vous avez ('+document.getElementById("nbrMailNonLu").value+') messages non lu',
										text : 'Vous avez recu '+document.getElementById("nbrMailNonLu").value+' nouveaux messages',
										sticky : false
									});
						}, 3000);

				// Magnific Popup
				// ================================
				$('#photo-album').magnificPopup({
					delegate : '.magnific',
					type : 'image',
					gallery : {
						enabled : true
					}
				});

				// Summernote
				// ================================
				$('.summernote').summernote(
						{
							height : 200,
							toolbar : [
									[ 'style', [ 'style' ] ],
									[
											'style',
											[ 'bold', 'italic', 'underline',
													'clear' ] ],
									[ 'fontsize', [ 'fontsize' ] ],
									[ 'color', [ 'color' ] ],
									[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
									[ 'height', [ 'height' ] ],
									[ 'table', [ 'table' ] ] ]
						});

				// Contact select
				// ================================
				(function() {
					var REGEX_EMAIL = '([a-z0-9!#$%&*+/=?^_`{|}~-]+(?:[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@'
							+ '(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)';

					var formatName = function(item) {
						return $.trim((item.firstName || '') + ' '
								+ (item.lastName || ''));
					};
					//Lecture de la liste des emails a partir de la base de doonées
					var myTab = [];
					$('#listMails > option').each(function() {
						var element = {};
						element['email'] = this.value;
						element['firstName'] = '';
						element['lastName'] = '';
						myTab.push(element);
						
					})
					// contact
					$('#selectize-contact')
							.selectize(
									{
										
										persist : false,
										maxItems : null,
										valueField : 'email',
										labelField : 'name',
										searchField : [ 'firstName',
												'lastName', 'email' ],
										sortField : [ {
											field : 'firstName',
											direction : 'asc'
										}, {
											field : 'lastName',
											direction : 'asc'
										} ],
										options : myTab
											,
										render : {
											item : function(item, escape) {
												var name = formatName(item);
												return '<div>'
														+ (name ? '<span class="name">'
																+ escape(name)
																+ '</span>'
																: '')
														+ (item.email ? '<small class="text-muted ml10">'
																+ escape(item.email)
																+ '</small>'
																: '')
														+ '</div>';
											},
											option : function(item, escape) {
												var name = formatName(item);
												var label = name || item.email;
												var caption = name ? item.email
														: null;
												return '<div>'
														+ '<span class="text-primary">'
														+ escape(label)
														+ '</span><br/>'
														+ (caption ? '<small class="text-muted">'
																+ escape(caption)
																+ '</small>'
																: '')
														+ '</div>';
											}
										},
										create : function(input) {
											if ((new RegExp('^' + REGEX_EMAIL
													+ '$', 'i')).test(input)) {
												return {
													email : input
												};
											}
											var match = input.match(new RegExp(
													'^([^<]*)<' + REGEX_EMAIL
															+ '>$', 'i'));
											if (match) {
												var name = $.trim(match[1]);
												var postSpace = name
														.indexOf(' ');
												var firstName = name.substring(
														0, postSpace);
												var lastName = name
														.substring(postSpace + 1);

												return {
													email : match[2],
													firstName : firstName,
													lastName : lastName
												};
											}
											return false;
										}
									});
				})();
			});

		}));