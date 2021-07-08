import axios from "axios";

 const apiProduct = axios.create({
     baseURL: 'http://localhost:7070/product/',

})

export default apiProduct;