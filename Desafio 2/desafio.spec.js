'use strict';
const request = require('supertest');
const joiAssert = require('joi-assert');
const URL = 'http://www.omdbapi.com';

var ID_DO_FILME = 'tt1285016';
var API_KEY = '52ec71bf';

describe('DESAFIO 2', function () {
  it('Validação: título, ano e linguagem de filme', function (done) {
    request(URL)
    .get(`/?i=${ID_DO_FILME}&apikey=${API_KEY}`)
    .end(function (err, res) {
      joiAssert(res.status, 200);
      joiAssert(res.body.Response, true)
      joiAssert(res.body.Title, 'The Social Network');
      joiAssert(res.body.Year, 2010);
      joiAssert(res.body.Language, 'English, French');
      done(err);
    })
  });

  it('Validação: Busca de filme inexistente', function (done) {
    request(URL)
    .get(`/?i=invalido&apikey=${API_KEY}`)
    .end(function (err, res) {
      joiAssert(res.status, 200);
      joiAssert(res.body.Response, false)
      joiAssert(res.body.Error, 'Incorrect IMDb ID.')
      done(err);
    })
  });
});