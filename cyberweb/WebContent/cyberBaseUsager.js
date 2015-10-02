  // les objets 
  // class 
UsagerEntity =function(){
};
SiteEntity= function(){};
QuartierEntity= function(){};
  
$(function() {
    var dialog, form,

      name = $( "#name" ),
      prenom =$( "#prenom"),
      date = $( "#date" ),
      niveau = $( "#niveau" ),
      csp =$( "#csp"),
      ml =$( "#ml"),
      exclu = $( "#exclu" ),
      adresse = $( "#adresse" ),
      //site = $( "#site" ),
      site = $( "#selsite" ),
      quartier = $( "#quartier" ),
      allFields = $( [] ).add( name ).add( prenom ).add( date ).add( niveau ).add( csp ).add( ml ).add( exclu ).add( adresse ).add( site ).add( quartier ),
      tips = $( ".validateTips" );
	
	
	// TODO récupérer la liste des sites sur le serveur !
	var les_sites = [
	  {id : 1, nom: 'Nantes Nord'},
	  {id : 2, nom: 'Nantes Sud'},
	  {id : 3, nom: 'Nantes centre'},
	  {id : 4, nom: 'Nantes est'}
	];

	// TODO récupérer la liste des quartier sur le serveur !
	var les_quartiers = [
	  {id : 1, nom: 'depomme'},
	  {id : 2, nom: 'padeu'},
	  {id : 3, nom: 'Jacques'},
	  {id : 4, nom: 'Nord'}
	];
 
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
      setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );
        updateTips( "Length of " + n + " must be between " +
          min + " and " + max + "." );
        return false;
      } else {
        return true;
      }
    }
 
    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
        o.addClass( "ui-state-error" );
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }
 
    function addUser() {
      var valid = true;
      allFields.removeClass( "ui-state-error" );
 
      valid = valid && checkLength( name, "username", 3, 16 );
      valid = valid && checkLength( prenom, "prenom", 3, 16 );
      valid = valid && checkLength( date, "date", 6, 16 );
      valid = valid && checkLength( niveau, "niveau", 5, 16 );
      valid = valid && checkLength( csp, "csp", 3, 16 );
      valid = valid && checkLength( ml, "ml", 3, 16 );
      valid = valid && checkLength( exclu, "exclu", 3, 16 );
      valid = valid && checkLength( adresse, "adresse", 3, 80 );
//      valid = valid && checkLength( site, "site", 3, 16 );
//      valid = valid && checkLength( quartier, "quartier", 3, 16 );
 
      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );

 
      if ( valid ) {
		function choiselement(elem) {
//		  console.log('ceci:'+this );
		  return (elem.id == this);
		}
        var siteusager=les_sites.filter(choiselement, site.val())[0];
        var quartierusager=les_quartiers.filter(choiselement, quartier.val())[0];
		var usager={
			civilite : 'mr',
			nom : name.val() ,
			prenom : prenom.val(),
			accompagneMissionLocale:ml.val(),
			dateDeNaissance:date.val(),
			excluService:exclu.val() ,
			niveauDeFormation: niveau.val(),
			adresse:{rue :adresse.val() },
			quartierPrioritaire: quartierusager,
			site:siteusager,
			utilisateur:{id:1},
		}
		console.log(siteusager);	
		console.log(quartierusager, quartierusager.nom);	

		$.ajax({
			method: "POST",
			url: "http://localhost:8080/cyberapi/api/usager",
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify(usager) 
		}).done(function() {
			console.log("!!!CA MARCHE !!");;
		});	
	  
        $( "#Tableau" ).append( "<div class='ligne'>" +
          "<div class='TabU'>" + name.val() + "</div>" +
          "<div class='TabU'>" + prenom.val() + "</div>" +
          "<div class='TabU'>" + date.val() + "</div>" +
          "<div class='TabU'>" + niveau.val() + "</div>" +
          "<div class='TabU'>" + csp.val() + "</div>" +
          "<div class='TabU1'>" + ml.val() + "</div>" +
          "<div class='TabU1'>" + exclu.val() + "</div>" +
          "<div class='TabU2'>" + adresse.val() + "</div>" +
          "<div class='TabU'>" + siteusager.nom+ "</div>" +
          "<div class='TabU'>" + quartierusager.nom + "</div>" +
        "</div>" );
          var id_old = parseInt(localStorage.getItem('id_distrib'));
          var id_new = id_old + 1;
		  
          localStorage.setItem('id_distrib', id_new);
          localStorage.setItem('usager'+id_new , "id : " + id_new + " ; " +
                                                 "nom : " + name.val() + " ; " +
                                                 "prenom : " + prenom.val() + " ; " +
                                                 "date : " + date.val() + " ; " +
                                                 "niveau : " + niveau.val() + " ; " +
                                                 "csp : " + csp.val() + " ; " +
                                                 "ml : " + ml.val() + " ; " +
                                                 "exclu : " + exclu.val() + " ; " +
                                                 "adresse : " + adresse.val() + " ; " +
                                                 "site : " + site.val() + " ; " +
                                                 "quartier : " + quartier.val() + " ; ");
          

		
    //    var usager = new UsagerEntity;
	//	usager	
          
          
        dialog.dialog( "close" );
      }
      return valid;
    }
 
    dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 500,
      width: 450,
      modal: true,
      buttons: {
        "Ajouter ": addUser,
        Annuler: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        form[ 0 ].reset();
        allFields.removeClass( "ui-state-error" );
      }
    });
 
    form = dialog.find( "form" ).on( "submit", function( event ) {
      event.preventDefault();
      addUser();
    });
 
    $( "#create-user" ).on( "click", function() {
		// alimenter les divers site possible
		site.empty();
		$(les_sites).each(function() {
		 site.append($("<option>").attr('value',this.id).text(this.nom));
		});	
		quartier.empty();
		$(les_quartiers).each(function() {
		 quartier.append($("<option>").attr('value',this.id).text(this.nom));
		});	
		dialog.dialog( "open" );
    });
  
  
	$('#clear').click( function() {
        window.localStorage.clear();
        localStorage.setItem('id_distrib', 0);
        location.reload();
      return false;
	});
      
      
      

  
});