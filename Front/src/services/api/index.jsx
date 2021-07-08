import axios from "axios";

 const apiProduct = axios.create({
     baseURL: 'http://localhost:7050/product/',

})

export default apiProduct;