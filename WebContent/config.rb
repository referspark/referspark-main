# If you installed bootstrap-sass in the previous 
# step and are using Twitter's Bootstrap
require 'bootstrap-sass';

# Set this to the root of your project when deployed:
CSS_dir = "css"
images_dir = "assets/images"
javascripts_dir = "js"

sass_dir = "css/sass"
#add_import_path "another/path/to/sCSS/files"
#add_import_path "yet/another/path/to/sCSS/files"

output_style = :compressed
line_comments = false		


# How to run #

# run once:
#compass compile --config config.rb /path/to/project

# keep it running and recompile when the source file(s) change
#compass watch --config config.rb /path/to/project