import React, {Component} from 'react';
import THREE from 'three';
import orbitControls from 'three-orbit-controls';
import $ from 'jquery';

const OrbitControls = orbitControls(THREE);

class Dashboard extends Component {
  constructor() {
    this.camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 1, 10000);
    this.camera.position.z = 250;

    this.scene = new THREE.Scene();

    const geometry = new THREE.BoxGeometry(200, 200, 200);
    this.material = new THREE.MeshLambertMaterial({color: 0xffffff, wireframe: false});

    this.mesh = new THREE.Mesh(geometry, this.material);

    const sunLight = new THREE.DirectionalLight(0xffffff, 0.5);
    sunLight.position.set(0, 1, 0.5);

    const ambientLight = new THREE.AmbientLight(0x3f3f3f);

    // this.scene.add(this.mesh);
    this.scene.add(sunLight);
    this.scene.add(ambientLight);

    this.genBullshit();
  }

  genBullshit() {
    const bullshit = $.ajax({
      url: `/api/city`,
      type: 'GET',
      accepts: {
        json: 'application/json',
      },
    });

    bullshit.fail((d) => console.log('fail',d));

    bullshit.done((d) => {
      console.log(d);
      for (let i = 0; i < d.length; i++) {
        const r = d[i];
        this.createRoad(new THREE.Vector3(r.a.x, r.a.y, r.a.z), new THREE.Vector3(r.b.x, r.b.y, r.b.z));
      }
    });
  }

  componentDidMount() {
    const canvas = document.getElementById('viewport-canvas');
    this.renderer = new THREE.WebGLRenderer({canvas: canvas});
    this.renderer.setSize( window.innerWidth, window.innerHeight );

    this.controls = new OrbitControls(this.camera);
    this.controls.damping = 0.2;
    this.controls.addEventListener('change', this.render);

    this.animate();
  }

  render() {
    //onClick={() => this.createRoad(new THREE.Vector3(-100, 0, 0), new THREE.Vector3(100, 0, 0))}
    return (
      <canvas id="viewport-canvas">
        Yo get a better browser.
      </canvas>
    );
  }

  animate() {
    requestAnimationFrame(this.animate.bind(this));

    this.controls.update();

    this.renderer.render( this.scene, this.camera );
  }

  createRoad(a, b) {
    const materialLine = new THREE.LineBasicMaterial({color: 0x0f0fff, linewidth: 5});
    const geometryLine = new THREE.Geometry();
    geometryLine.vertices.push(a, b);
    const line = new THREE.Line(geometryLine, materialLine);

    this.scene.add(line);
  }
}

export default Dashboard;
