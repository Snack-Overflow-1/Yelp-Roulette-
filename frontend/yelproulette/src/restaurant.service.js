import http from "../http-common";

class RestaurantDataService{
    
    getRandom(){
        return http.get("/randomRestaurant");
    }
}

export default new RestaurantDataService();