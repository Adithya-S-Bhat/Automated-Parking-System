# Dsiplay a simple chart
import geocoder
from geopy.geocoders import Nominatim

g = geocoder.ip('me')

geolocator = Nominatim(user_agent="geoapiExercises")
 
Latitude = str(g.latlng[0])
Longitude = str(g.latlng[1])
 
print(Latitude)
print(Longitude)
 
location = geolocator.geocode(Latitude+","+Longitude)
 
print(location)

 


