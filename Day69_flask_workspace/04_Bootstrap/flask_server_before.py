from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)


@app.route("/boot_before", methods=["GET"])
def boot_test():
    return jsonify(success=True)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port="7777")
