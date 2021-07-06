import React, {Component} from 'react';
import apiProduct from "../../../services/api";


class Form extends Component {


    state={
        product: []
    }


    async componentDidMount() {
        console.log('passsei aqui')
        const response = await apiProduct.get('')
        this.state({product: response.data})
    }

    render() {
        return (
            <form>
                <div className="form-group m-2">
                    <label>Nome do Produto</label>
                    <input type="text" className="form-control m-2" placeholder="Nome do Produto"/>
                </div>
                <div className="form-group m-2">
                    <label>Preço do Produto</label>
                    <input type="float" className="form-control m-2" placeholder="Preço do Produto"/>
                </div>
                <div className="form-group m-2">
                    <label htmlFor="exampleFormControlTextarea1">Descrição do Produto</label>
                    <textarea className="form-control m-2" placeholder="Descrição do Produto" rows="3"></textarea>
                </div>
            </form>
        )
    }



}

export default Form;