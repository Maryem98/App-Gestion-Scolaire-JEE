<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Ajouter un eleve</title>

    <!-- Icons font CSS-->
    <link href="form/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="form/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="form/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="form/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="form/css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Ajouter un nouveau parent</h2>
                </div>
                <div class="card-body">
                    <form action="saveparent.dot" method="POST">
                    <div class="form-row">
                            <div class="name">IDP</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="IDP">
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Nom</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="nom">
                                            <label class="label--desc">Laste name</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="prenom">
                                            <label class="label--desc">First name</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Date de naissance</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="dateNaissance">
                                </div>
                            </div>
                        </div>
                         <!--  <div class="form-row">
                           <div class="name">Classe</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="classe">
                                </div>
                            </div>
                        </div> -->
                      
                        
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="form/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="form/vendor/select2/select2.min.js"></script>
    <script src="form/vendor/datepicker/moment.min.js"></script>
    <script src="form/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="form/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->