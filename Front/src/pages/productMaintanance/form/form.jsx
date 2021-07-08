import React, {useState} from 'react';
import apiProduct from "../../../services/api";



const Form = () => {
    const [product, setProduct] = useState({
        id: '',
        name: '',
        preco: '',
        description: ''
    });

    const valueInput = e => setProduct({ ...product, [e.target.name]: e.target.value });


    const handleNewProdcut = async () => {
        const response = await apiProduct.post('', product)
        console.log(response)
    }

    const handleEdit = async () => {
        const response = await apiProduct.put(product.id+'', product)
        console.log(response)
    }

    const handleDelete = async () => {
        const response = await apiProduct.delete(product.id+'')
        setProduct({
            id: '',
            name: '',
            preco: '',
            description: ''
        })
        console.log(response)
    }

    const handleGetProduct = async () => {
        const response = await apiProduct.get(product.id+'')
        setProduct(response.data)
        console.log(response)
    }

    return (
            <form >
                <div className="form-group m-2">
                    <label>Id do Produto</label>
                    <input value={product.id}  name={'id'} type="text" className="form-control m-2" placeholder="Id do Produto" onChange={valueInput}/>
                </div>
                <div className="form-group m-2">
                    <label>Nome do Produto</label>
                    <input value={product.name} name={'name'} type="text" className="form-control m-2" placeholder="Nome do Produto" onChange={valueInput} />
                </div>
                <div className="form-group m-2">
                    <label>Preço do Produto</label>
                    <input value={product.preco} name={'preco'} type="float" className="form-control m-2" placeholder="Preço do Produto" onChange={valueInput}/>
                </div>
                <div className="form-group m-2">
                    <label  htmlFor="exampleFormControlTextarea1">Descrição do Produto</label>
                    <textarea value={product.description} name={'description'} className="form-control m-2" placeholder="Descrição do Produto" rows="3" onChange={valueInput}></textarea>
                </div>
                <div className="align-content-center text-center">
                    <p>
                        <a href="#" className="btn btn-dark my-2"  onClick={handleGetProduct}>Vizualizar</a>
                        <a href="#" className="btn btn-secondary my-2" onClick={handleNewProdcut}>Criar</a>
                        <a href="#" className="btn btn-dark my-2" onClick={handleEdit} > Editar</a>
                        <a href="#" className="btn btn-secondary my-2" onClick={handleDelete}>Excluir</a>

                    </p>
                    {/*<button type="submit" className="btn btn-dark my-2 " >Enviar</button>*/}
                </div>
            </form>
)



}

export default Form;