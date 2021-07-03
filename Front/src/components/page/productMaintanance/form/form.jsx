import React from 'react';


const Form = () => {

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

export default Form;