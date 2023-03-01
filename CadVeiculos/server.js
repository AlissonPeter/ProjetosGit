const Client = require('pg').Client
const cliente = new Client({
    user: "postgres",
    password: "alisson",
    host: "localhost",
    port: 5432,
    database: "db_veiculoweb"
});
cliente.connect();

const express = require('express');
const bodyParser = require('body-parser');
var urlencodedParser = bodyParser.urlencoded({ extended: false })
const path = require('path');
const app = express();

const alerta = require('alert');
const { post } = require('request-promise');

app.get('/', function (req, res) {
    loadVehicles(res);
});

app.post('/', urlencodedParser, function (req, res) {
    try {
        if (validarCampos(req, res)) {
            insertVeiculo(req.body.txtPlaca, req.body.txtMarca, req.body.txtModelo);
            loadVehicles(res);
        }
    } catch (ex) {
        console.log(ex);
    }
});

function validarCampos(req, res) {
    if (req.body.txtPlaca.trim() == '' || req.body.txtMarca.trim() == '' || req.body.txtModelo.trim() == '') {
        return false;
    }
    /*if (loadVehiclesByPlaca(req.body.txtPlaca)) {
        return false;
    }*/
    return true;
}


app.engine('ejs', require('ejs').renderFile);
app.set('view engine', 'ejs');
app.use(express.static("public"));
app.set('views', path.join(__dirname, '/views'));

app.listen(3000, () => {
    console.log('servidor rodando');
});

async function insertVeiculo(placa, marca, modelo) {
    try {
        await cliente.query('insert into veiculo (placa, marca, modelo) values (' + "'" + placa + "', '" + marca + "', '" + modelo + "');")
        console.log("Valor inserido na tabela!");
    } catch (ex) {
        console.log("Ocorreu erro! Erro: " + ex)
    }
}

async function loadVehiclesByPlaca(placa) {
    try {
        return (await cliente.query("select * from veiculo where placa = " + "'" + placa + "'")).rowCount > 0;
    } catch (ex) {
        console.log("Ocorreu erro! Erro: " + ex)
    }
}

async function loadVehicles(res) {
    try {
        const resultado = await cliente.query("select * from veiculo");
        const listaVeiculos = resultado.rows;
        res.render('pages/index', { lista: listaVeiculos });
    } catch (ex) {
        console.log("Ocorreu erro! Erro: " + ex)
    }
}

async function deleteVeiculo(placa) {
    try {
       // await cliente.query("delete from veiculo where placa = '" + placa + "'")
        console.log("Valor removido na tabela!")

        const resultado = await cliente.query("select * from veiculo")
        console.table(resultado.rows)
    } catch (ex) {
        console.log("Ocorreu erro! Erro: " + ex)
    }
    finally {
        await cliente.end();
        console.log("Cliente desconectado!")
    }
}
