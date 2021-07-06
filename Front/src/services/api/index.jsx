import axios from "axios";

 const apiProduct = axios.create({
     method: 'get',
    baseURL: 'localhost:7070//product'
})

export default apiProduct;